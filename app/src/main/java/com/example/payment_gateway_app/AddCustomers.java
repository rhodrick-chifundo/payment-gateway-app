package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCustomers extends AppCompatActivity {
    EditText Svname, CUsaname, Csreff, CSbill;
    TextView submit, register2, home;
    FirebaseDatabase database;
    DatabaseReference check, check2, check3, check4;
    ProgressBar pbar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customers);

        Svname = (EditText)findViewById(R.id.Vname);
        CUsaname = (EditText)findViewById(R.id.CVname);
        Csreff = (EditText)findViewById(R.id.Cvreff);
        CSbill = (EditText)findViewById(R.id.Csbill);
        pbar2 = (ProgressBar)findViewById(R.id.pBar2);

        submit = (TextView) findViewById(R.id.Sub);
        register2 = (TextView) findViewById(R.id.reg2);
        home= (TextView) findViewById(R.id.hom1);


        database = FirebaseDatabase.getInstance();
        check3 = database.getReference("MERCHANTS CUSTOMERS");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbar2.setVisibility(View.VISIBLE);
                String serviceName = Svname.getText().toString();
                String customerName = CUsaname.getText().toString();
                String referenceNumber = Csreff.getText().toString();
                String customerBill = CSbill.getText().toString();
                if(TextUtils.isEmpty(serviceName)){
                    Svname.setError("enter company name");
                    Svname.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(customerName)){
                    CUsaname.setError("enter customer name");
                    CUsaname.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(referenceNumber)){
                    Csreff.setError("enter reference number");
                    Csreff.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(customerBill)){
                    CSbill.setError("enter customer bill or 0MK if customer have no bill");
                    CSbill.requestFocus();
                    return;
                }
                check4 = database.getReference("MERCHANTS CUSTOMERS").child(serviceName);
                customers customers1 = new customers(serviceName, customerName, referenceNumber, customerBill);
                check4.child(referenceNumber).setValue(customers1);
                CUsaname.setText(null);
                Csreff.setText(null);
                CSbill.setText(null);
               check3.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                   @Override
                   public void onComplete(@NonNull Task<DataSnapshot> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(AddCustomers.this,"operation successful ", Toast.LENGTH_LONG).show();
                          pbar2.setVisibility(View.GONE);
                      }
                   }
               });
            }
        });

        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCustomers.this, RegisterSivice.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCustomers.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}