package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class CredeptCard extends AppCompatActivity {
    String s1, s2, s3, s4, s5, s6;
    TextView result1, result2,result3;
    TextView t1, t3, t4, home, tNun3, tbal4, tcvv5, tv6, t7, t8,t9, t10, t11, t12, t13, t14;
     EditText et1, Cnumber2, Cname3, Ccvv4, ett8, ett9, ett10, ett11;
    FirebaseDatabase database;
    DatabaseReference check, check2, check3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credept_card);
        t3 = (TextView)findViewById(R.id.et4);
        t4 = (TextView)findViewById(R.id.expiation);
        t1 = (TextView)findViewById(R.id.metch);
        tv6 = (TextView)findViewById(R.id.t6);
        t7 = (TextView)findViewById(R.id.t8);
        t8 = (TextView)findViewById(R.id.t5);
        t9 = (TextView)findViewById(R.id.txc);
        t10 = (TextView)findViewById(R.id.ttt5);
       home = (TextView)findViewById(R.id.hom);
        et1 = (EditText) findViewById(R.id.refnum);
        t11 = (TextView)findViewById(R.id.ttt6);
        t12 = (TextView)findViewById(R.id.ttt7);
        t13 = (TextView)findViewById(R.id.canel);
        t14 = (TextView)findViewById(R.id.paipal1);
        ett10 = (EditText) findViewById(R.id.Cnum1);
        tNun3 = (TextView)findViewById(R.id.txb);
        tbal4 = (TextView)findViewById(R.id.txa);
        tcvv5 = (TextView)findViewById(R.id.t7);
        Cnumber2 = (EditText)findViewById(R.id.et3);
        Cname3 = (EditText)findViewById(R.id.et6);
        Ccvv4 = (EditText)findViewById(R.id.et7);


        result1 = (TextView)findViewById(R.id.res1);
        result2 = (TextView)findViewById(R.id.res2);
        result3 = (TextView)findViewById(R.id.res3);




        s1 = getIntent().getExtras().getString("ment");
        t1.setText(s1);


        database = FirebaseDatabase.getInstance();
       check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check2 = database.getReference("BANK").child("MERCHANTS");
        check3 = database.getReference("MERCHANTS CUSTOMERS");

     home.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(CredeptCard.this, MainActivity.class);
             startActivity(intent);
         }
     });



        t8.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                  String a1 = Cnumber2.getText().toString();
                  String a2 = t3.getText().toString();
                  String a3 = Ccvv4.getText().toString();
                  String a4 = Cname3.getText().toString();
                  String a5 = ett10.getText().toString();
                  String a6 = et1.getText().toString();



                 String checkName = Cname3.getText().toString();
                 check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
                 Query chech1 = check.orderByChild("account name").equalTo(checkName);
                 chech1.addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot snapshot) {
                         if(snapshot.exists()){
                             t11.setVisibility(View.VISIBLE);
                             t10.setVisibility(View.VISIBLE);
                             t14.setVisibility(View.VISIBLE);
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
                         else {
                             Cname3.setError("invalid card name");
                             Cname3.requestFocus();
                             return;
                         }
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError error) {

                     }
                 });




                 if(TextUtils.isEmpty(a1)){
                     Cnumber2.setError("fill card number");
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
                 if (TextUtils.isEmpty(a5)){
                     ett10.setError(" enter amount");
                     ett10.requestFocus();
                     return;
                 }
                 if (TextUtils.isEmpty(a6)){
                     et1.setError(" enter reference number");
                     et1.requestFocus();
                     return;
                 }

              else  { }

                 s3 = t1.getText().toString();
                     check2.child(s3).addValueEventListener(new ValueEventListener() {
                         @Override
                         public void onDataChange(@NonNull DataSnapshot snapshot) {
                             String balance = snapshot.child("accountBalance").getValue().toString();
                             tv6.setText(balance);

                         }

                         @Override
                         public void onCancelled(@NonNull DatabaseError error) {

                         }


                     });

                 s5 = t1.getText().toString();
                 s6 = et1.getText().toString();
                 check3.child(s5).child(s6).addValueEventListener(new ValueEventListener() {
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
         });


         t11.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 long a = Long.parseLong(tNun3.getText().toString());
                 long b = Long.parseLong(Cnumber2.getText().toString());

                 long c = Long.parseLong(tbal4.getText().toString());
                 long d = Long.parseLong(ett10.getText().toString());

                 int e = Integer.parseInt(Ccvv4.getText().toString());
                 int f = Integer.parseInt(tcvv5.getText().toString());

                 String g = t4.getText().toString();
                 String h = t3.getText().toString();

                 if(a != b){
                     Cnumber2.setError("invalid Card number entered");
                     Cnumber2.requestFocus();
                     return;
                 }
                 else if ( c <= d){
                     ett10.setError("you have insufficient balance");
                     ett10.requestFocus();
                     return;

                 }

                else if(!g.contentEquals(h)){
                     t3.setError("invalid expire date");
                    t3.requestFocus();
                     return;
                 }
               else if(e != f){
                     Ccvv4.setError("invalid cvv entered");
                     Ccvv4.requestFocus();
                     return;
                 }



                 else {
                     t13.setVisibility(View.VISIBLE);
                   t12.setVisibility(View.VISIBLE);
                     long a1 = Long.parseLong(ett10.getText().toString());
                     long  a2 = Long.parseLong(tbal4.getText().toString());
                     long c1 = a2 - a1;
                    result1.setText(String.valueOf(c1));

                     long b1 = Long.parseLong(tv6.getText().toString());
                     long b2 = Long.parseLong(ett10.getText().toString());
                     long b3 = b1 + b2;
                    result2.setText(String.valueOf(b3));

                     long d1 = Long.parseLong(t7.getText().toString());
                     long d2 = Long.parseLong(ett10.getText().toString());
                     long d3 = d1 - d2;
                     result3.setText(String.valueOf(d3));
                 Toast.makeText(CredeptCard.this,"entered amount will be deducted from your bank",Toast.LENGTH_LONG ).show();
               }

             }
         });
         t10.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 long a = Long.parseLong(tNun3.getText().toString());
                 long b = Long.parseLong(Cnumber2.getText().toString());

                 int e = Integer.parseInt(Ccvv4.getText().toString());
                 int f = Integer.parseInt(tcvv5.getText().toString());

                 String g = t4.getText().toString();
                 String h = t3.getText().toString();

                 if(a != b){
                     Cnumber2.setError("invalid Card number entered");
                     Cnumber2.requestFocus();
                     return;
                 }

                 else if(!g.contentEquals(h)){
                     t3.setError("invalid expire date");
                     t3.requestFocus();
                     return;
                 }
                 else if(e != f){
                     Ccvv4.setError("invalid cvv entered");
                     Ccvv4.requestFocus();
                     return;
                 }

                 else {
                     t12.setVisibility(View.VISIBLE);
                     t13.setVisibility(View.VISIBLE);
                     Long  a1 = Long.parseLong(ett10.getText().toString());
                     Long  a2 = Long.parseLong(tbal4.getText().toString());
                     long  c1 = a2 - a1;
                     result1.setText(String.valueOf(c1));

                     Long b1 = Long.parseLong(tv6.getText().toString());
                     Long b2 = Long.parseLong(ett10.getText().toString());
                     long b3 = b1 + b2;
                     result2.setText(String.valueOf(b3));

                     long  d1 = Long.parseLong(t7.getText().toString());
                     long  d2 = Long.parseLong(ett10.getText().toString());
                     long d3 = d1 - d2;
                     result3.setText(String.valueOf(d3));
                     Toast.makeText(CredeptCard.this,"entered amount will be deducted from your bank",Toast.LENGTH_LONG ).show();
                 }


             }
         });
         t12.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 t11.setVisibility(View.INVISIBLE);
                 t10.setVisibility(View.INVISIBLE);
                 t12.setVisibility(View.INVISIBLE);
                 t13.setVisibility(View.INVISIBLE);
                 t14.setVisibility(View.INVISIBLE);


                 s4 = Cname3.getText().toString();
                 check.child(s4).addValueEventListener(new ValueEventListener() {

                     @Override
                     public void onDataChange(@NonNull DataSnapshot snapshot) {

                         int a1 = Integer.parseInt(result1.getText().toString());
                         Map<String, Object> hashMap = new HashMap<>();
                         hashMap.put("account balance", a1);
                         snapshot.getRef().updateChildren(hashMap);
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError error) {

                     }
                 });

                 s5 = t1.getText().toString();
                 check2.child(s5).addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot snapshot) {
                         long a1 = Long.parseLong(result2.getText().toString());
                         Map<String, Object> hashMap = new HashMap<>();
                         hashMap.put("accountBalance", a1);
                         snapshot.getRef().updateChildren(hashMap);
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError error) {

                     }
                 });

                 s5 = t1.getText().toString();
                 s6 = et1.getText().toString();
                 check3.child(s5).child(s6).addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot snapshot) {
                         int a1 = Integer.parseInt(result3.getText().toString());
                         Map<String, Object> hashMap = new HashMap<>();
                         hashMap.put("customerBill", a1);
                         snapshot.getRef().updateChildren(hashMap);
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError error) {

                     }
                 });
                 Cname3.setText("");
                 Cnumber2.setText("");
                 Ccvv4.setText("");
                 t3.setText("");
                 ett10.setText("");
                 et1.setText("");
            }

        });

         t13.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Cname3.setText("");
                 Cnumber2.setText("");
                 Ccvv4.setText("");
                 t3.setText("");
                 ett10.setText("");
                 et1.setText("");

             }
         });
         t14.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String sa = ett10.getText().toString();
                 Intent intent = new Intent(CredeptCard.this, Paypal.class );
                 intent.putExtra("ment", sa);
                 startActivity(intent);
             }
         });


    }
}