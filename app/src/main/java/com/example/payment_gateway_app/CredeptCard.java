package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CredeptCard extends AppCompatActivity {
    String s1, s2, s3, s4, s5, s6;

    TextView t1, t2, tNun3, tbal4, tcvv5, tv6, t7, t8,t9, t10;
     EditText et1, Cnumber2, Cname3, Ccvv4, ett8;
    FirebaseDatabase database;
    DatabaseReference check, check2, check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credept_card);
        t1 = (TextView)findViewById(R.id.amont);
        t2 = (TextView)findViewById(R.id.reffnum);
        tv6 = (TextView)findViewById(R.id.t6);
        t7 = (TextView)findViewById(R.id.t8);
        t8 = (TextView)findViewById(R.id.t5);
        t9 = (TextView)findViewById(R.id.txc);
        t10 = (TextView)findViewById(R.id.ttt5);
        ett8 = (EditText) findViewById(R.id.et9);
        tNun3 = (TextView)findViewById(R.id.txb);
        tbal4 = (TextView)findViewById(R.id.txa);
        tcvv5 = (TextView)findViewById(R.id.t7);
        et1 = (EditText)findViewById(R.id.et8);
        Cnumber2 = (EditText)findViewById(R.id.et3);
        Cname3 = (EditText)findViewById(R.id.et6);
        Ccvv4 = (EditText)findViewById(R.id.et7);






        s1 = getIntent().getExtras().getString("anmt1");
        t1.setText(s1);
        s2 = getIntent().getExtras().getString("sett1");
        ett8.setText(s2);
        s3 = getIntent().getExtras().getString("set1");
        et1.setText(s3);

        s5 = et1.getText().toString();
        database = FirebaseDatabase.getInstance();
        check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check2 = database.getReference("BANK").child("MERCHANTS");
        check3 = database.getReference("MERCHANTS CUSTOMERS").child(s5);

         t10.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            s4 = Cname3.getText().toString();

            check.child(s4).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String Cnumber = snapshot.child("card number").getValue().toString();
                    String balance = snapshot.child("account balance").getValue().toString();
                    String cvv1 = snapshot.child("cvv").getValue().toString();
                    tNun3.setText(Cnumber);
                    tbal4.setText(balance);
                    tcvv5.setText(cvv1);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            check2.child(s5).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String balance = snapshot.child("accountBalance").getValue().toString();
                    tv6.setText(balance);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
             }
         });
        s6 = ett8.getText().toString();
         check3.child(s6).addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {
                 String bil = snapshot.child("customerBill").getValue().toString();
                 String nam = snapshot.child("customerName").getValue().toString();
                 t7.setText(bil);
                 t9.setText(nam);
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

             }
         });

    }
}