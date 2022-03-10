package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CredeptCard extends AppCompatActivity {
    String s1, s2, s3, s4, s5, s6;

    TextView t1, t2, t3, t4, date, tNun3, repoti, tbal4, tcvv5, tv6, t7, t8,t9, t10, t11, t12;
     EditText et1, Cnumber2, Cname3, Ccvv4, ett8;
    FirebaseDatabase database;
    DatabaseReference check, check2, check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credept_card);
        t1 = (TextView)findViewById(R.id.amont);
        t2 = (TextView)findViewById(R.id.reffnum);
        t3 = (TextView)findViewById(R.id.et4);
        t4 = (TextView)findViewById(R.id.expiation);
        tv6 = (TextView)findViewById(R.id.t6);
        t7 = (TextView)findViewById(R.id.t8);
        t8 = (TextView)findViewById(R.id.t5);
        t9 = (TextView)findViewById(R.id.txc);
        t10 = (TextView)findViewById(R.id.ttt5);
        t11 = (TextView)findViewById(R.id.ttt6);
        t12 = (TextView)findViewById(R.id.ttt7);
        ett8 = (EditText) findViewById(R.id.et9);
        tNun3 = (TextView)findViewById(R.id.txb);
        tbal4 = (TextView)findViewById(R.id.txa);
        tcvv5 = (TextView)findViewById(R.id.t7);
        et1 = (EditText)findViewById(R.id.et8);
        repoti = (EditText)findViewById(R.id.repot);
        Cnumber2 = (EditText)findViewById(R.id.et3);
        Cname3 = (EditText)findViewById(R.id.et6);
        Ccvv4 = (EditText)findViewById(R.id.et7);
        date = (EditText)findViewById(R.id.et4);






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




         t8.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                  String a1 = Cnumber2.getText().toString();
                  String a2 = t3.getText().toString();
                  String a3 = Ccvv4.getText().toString();
                  String a4 = Cname3.getText().toString();

                 if(TextUtils.isEmpty(a1)){
                     Cnumber2.setError("Card number not be emputy");
                     Cnumber2.requestFocus();
                     return;
                 }
                 if(TextUtils.isEmpty(a2)){
                     t3.setError(" fill in expiration date");
                     t3.requestFocus();
                 return;
                 }
                 if (TextUtils.isEmpty(a4)){
                     Cname3.setError("fill in name");
                     Cname3.requestFocus();
                     return;
                 }
                 if (TextUtils.isEmpty(a3)){
                     Ccvv4.setError(" fill in cvv code");
                     Ccvv4.requestFocus();
                     return;
                 }
                 else {
                     t11.setVisibility(View.VISIBLE);
                     t10.setVisibility(View.VISIBLE);

                     s4 = Cname3.getText().toString();
                     check.child(s4).addValueEventListener(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                             String Cnumber = snapshot.child("card number").getValue().toString();
                             String balance = snapshot.child("account balance").getValue().toString();
                             String cvv1 = snapshot.child("cvv").getValue().toString();
                             String expire = snapshot.child("expirationDate").getValue().toString();
                             tNun3.setText(Cnumber);
                             tbal4.setText(balance);
                             tcvv5.setText(cvv1);
                             t4.setText(expire);
                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {

                         }
                     });

                 }


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



         t11.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 long a = Long.parseLong(tNun3.getText().toString());
                 long b = Long.parseLong(Cnumber2.getText().toString());

                 long c = Long.parseLong(tbal4.getText().toString());
                 long d = Long.parseLong(t1.getText().toString());

                 int e = Integer.parseInt(Ccvv4.getText().toString());
                 int f = Integer.parseInt(tcvv5.getText().toString());

                 String g = t4.getText().toString();
                 String h = date.getText().toString();

                 if(a != b){
                     Cnumber2.setError("invalid Card number entered");
                     Cnumber2.requestFocus();
                     return;
                 }
                 if(c <= d){
                     repoti.setError("you have insufficient account balance");
                     repoti.requestFocus();
                     return;
                 }
                 if(!g.contentEquals(h)){
                     date.setError("invalid expire date");
                     date.requestFocus();
                     return;
                 }
                 if(e != f){
                     Ccvv4.setError("invalid cvv entered");
                     Ccvv4.requestFocus();
                     return;
                 }

                 else {
                     Cnumber2.setText("you are good to go");
                     t12.setVisibility(View.VISIBLE);
                 }

             }
         });
         t10.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });

    }
}