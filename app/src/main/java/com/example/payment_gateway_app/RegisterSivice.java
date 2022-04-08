 package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

 public class RegisterSivice extends AppCompatActivity {
    EditText Svname, Sbankaname, Sbanknum, SvUname;
    TextView Svbalance, home, register3;
    Button submit1;
    FirebaseDatabase database;
    DatabaseReference check, check2, check3, check4;
    ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_sivice);


        Svname = (EditText)findViewById(R.id.Sname);
        Sbankaname = (EditText)findViewById(R.id.Sbank);
        Sbanknum = (EditText)findViewById(R.id.Saccount);
        SvUname = (EditText)findViewById(R.id.Suname);
        Svbalance = (TextView)findViewById(R.id.balasi);
        submit1 = (Button) findViewById(R.id.sub1);
        register3 = (TextView) findViewById(R.id.reg3);
       home = (TextView) findViewById(R.id.home2);
       pBar = (ProgressBar)findViewById(R.id.pBar1);



        database = FirebaseDatabase.getInstance();
        check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check3 = database.getReference("MERCHANTS CUSTOMERS");
        check2 = database.getReference("BANK").child("MERCHANTS");


        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              pBar.setVisibility(View.VISIBLE);
              String accountBalance = Svbalance.getText().toString();
              String accountName = SvUname.getText().toString();
              String accountNumber = Sbanknum.getText().toString();
              String serviceName = Svname.getText().toString();
              if(TextUtils.isEmpty(accountName)){
                  pBar.setVisibility(View.GONE);
                    SvUname.setError("enter account name");
                    SvUname.requestFocus();
                    return;
                }
              if(TextUtils.isEmpty(accountNumber)){
                  pBar.setVisibility(View.GONE);
                  Sbanknum.setError("enter bank name");
                  Sbanknum.requestFocus();
                  return;
              }
              if(TextUtils.isEmpty(serviceName)) {
                  pBar.setVisibility(View.GONE);
                  Svname.setError("enter your company name");
                  Svname.requestFocus();
                  return;

              }
              else {
                    String name = Svname.getText().toString();
                  check2 = database.getReference("BANK").child("MERCHANTS");
                  Query cheke0 = check2.orderByChild("serviceName").equalTo(name);
                  cheke0.addListenerForSingleValueEvent(new ValueEventListener() {
                      @Override
                      public void onDataChange(@NonNull DataSnapshot snapshot) {
                          if(snapshot.exists()){
                              pBar.setVisibility(View.GONE);
                              Svname.setError(" merchant already exist");
                              Svname.requestFocus();
                              return;
                          }
                          else {
                              merchants merchants1 = new merchants(accountBalance, accountName, accountNumber, serviceName);
                              merchants2 merchantsa = new merchants2(serviceName);
                              check2.child(serviceName).setValue(merchants1);
                              check3.child(serviceName).setValue(merchantsa);
                              Svname.setText(null);
                              Sbankaname.setText(null);
                              Sbanknum.setText(null);
                              SvUname.setText(null);
                              check2.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                  @Override
                                  public void onComplete(@NonNull Task<DataSnapshot> task) {
                                      if (task.isSuccessful()) {
                                          Toast.makeText(RegisterSivice.this, "registration is successful! you can register more companies or leave", Toast.LENGTH_LONG).show();
                                          pBar.setVisibility(View.GONE);

                                      }
                                  }
                              });
                          }
                      }

                      @Override
                      public void onCancelled(@NonNull DatabaseError error) {

                      }
                  });

              }

            }
        });


        register3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterSivice.this, AddCustomers.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterSivice.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}






