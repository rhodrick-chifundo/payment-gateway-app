package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private Button go;
    EditText mechant;
    TextView add, Register1;
    FirebaseDatabase database;
    DatabaseReference check;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = (Button)findViewById(R.id.bba);
        mechant = (EditText)findViewById(R.id.tvc1);
        add = (TextView) findViewById(R.id.reg1);
        Register1 = (TextView) findViewById(R.id.custma);



        database = FirebaseDatabase.getInstance();

         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, RegisterSivice.class);
                 startActivity(intent);
             }
         });
         Register1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, AddCustomers.class);
                 startActivity(intent);
             }
         });
         go.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String mennt = mechant.getText().toString();
                 if(TextUtils.isEmpty(mennt)){
                     mechant.setError("type or select merchant on the list");
                     mechant.requestFocus();
                     return;
                 }
                 else {
                     String checkUser = mechant.getText().toString();
                     check = database.getReference("BANK").child("MERCHANTS");
                     Query chech1 = check.orderByChild("serviceName").equalTo(checkUser);
                     chech1.addListenerForSingleValueEvent(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                             if(snapshot.exists()){
                                 Intent intent = new Intent(MainActivity.this, CredeptCard.class);
                                 String s1 = mechant.getText().toString();
                                 intent.putExtra("ment", s1);
                                 mechant.setText("");
                                 mechant.setText("");
                              startActivity(intent);
                             }
                             else {
                                 mechant.setError("no such merchant exit");
                             }
                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {

                         }
                     });

                 }

             }


         });
    }
}