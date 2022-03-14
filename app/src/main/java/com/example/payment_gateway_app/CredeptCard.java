package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CredeptCard extends AppCompatActivity {
    String s1, s2, s3, s4, s5, s6;
    TextView result1, result2,result3;
    TextView t1, t3, t4, date, tNun3, tbal4, tcvv5, tv6, t7, t8,t9, t10, t11, t12;
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
        et1 = (EditText) findViewById(R.id.refnum);
        t11 = (TextView)findViewById(R.id.ttt6);
        t12 = (TextView)findViewById(R.id.ttt7);
        ett10 = (EditText) findViewById(R.id.Cnum1);
        tNun3 = (TextView)findViewById(R.id.txb);
        tbal4 = (TextView)findViewById(R.id.txa);
        tcvv5 = (TextView)findViewById(R.id.t7);
        Cnumber2 = (EditText)findViewById(R.id.et3);
        Cname3 = (EditText)findViewById(R.id.et6);
        Ccvv4 = (EditText)findViewById(R.id.et7);
        date = (EditText)findViewById(R.id.et4);

        result1 = (TextView)findViewById(R.id.res1);
        result2 = (TextView)findViewById(R.id.res2);
        result3 = (TextView)findViewById(R.id.res3);




        s1 = getIntent().getExtras().getString("ment");
        t1.setText(s1);


        database = FirebaseDatabase.getInstance();
       check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check2 = database.getReference("BANK").child("MERCHANTS");
        check3 = database.getReference("MERCHANTS CUSTOMERS");





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

//
//         t11.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 long a = Long.parseLong(tNun3.getText().toString());
//                 long b = Long.parseLong(Cnumber2.getText().toString());
//
//                 long c = Long.parseLong(tbal4.getText().toString());
//                 long d = Long.parseLong(t1.getText().toString());
//
//                 int e = Integer.parseInt(Ccvv4.getText().toString());
//                 int f = Integer.parseInt(tcvv5.getText().toString());
//
//                 String g = t4.getText().toString();
//                 String h = date.getText().toString();
//
//                 if(a != b){
//                     Cnumber2.setError("invalid Card number entered");
//                     Cnumber2.requestFocus();
//                     return;
//                 }
//
//                 if(!g.contentEquals(h)){
//                     date.setError("invalid expire date");
//                     date.requestFocus();
//                     return;
//                 }
//                 if(e != f){
//                     Ccvv4.setError("invalid cvv entered");
//                     Ccvv4.requestFocus();
//                     return;
//                 }

//                 else {
//                     t12.setVisibility(View.VISIBLE);
//
////                     String s1 = Cname3.getText().toString();
//
//                     check.child(s1).addValueEventListener(new ValueEventListener() {
//                         @Override
//                         public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                         }
//
//                         @Override
//                         public void onCancelled(@NonNull DatabaseError error) {
//
//                         }
//                     });
//                     String s2 = et1.getText().toString();
//                     check2.child(s2).addValueEventListener(new ValueEventListener() {
//                         @Override
//                         public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                         }
//
//                         @Override
//                         public void onCancelled(@NonNull DatabaseError error) {
//
//                         }
//                     });
//                     String s3 = ett8.getText().toString();
//                     check3.child(s3).addValueEventListener(new ValueEventListener() {
//                         @Override
//                         public void onDataChange(@NonNull DataSnapshot snapshot) {
//                             int a1 = Integer.parseInt(ett11.getText().toString());
//                             int a2 = Integer.parseInt(t7.getText().toString());
//                             int a3 = a1 + a2;
//                             result3.setText(String.valueOf(a3));
//                             String sa = result3.getText().toString();
//                             Map<String, Object> hashMap = new HashMap<>();
//                             hashMap.put("customerBill", result3);
//                             snapshot.getRef().updateChildren(hashMap);
//                         }
//
//                         @Override
//                         public void onCancelled(@NonNull DatabaseError error) {
//
//                         }
//                     });
 //                }

   //          }
//         });
//         t10.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 long a = Long.parseLong(tNun3.getText().toString());
//                 long b = Long.parseLong(Cnumber2.getText().toString());
//
//                 int e = Integer.parseInt(Ccvv4.getText().toString());
//                 int f = Integer.parseInt(tcvv5.getText().toString());
//
//                 String g = t4.getText().toString();
//                 String h = date.getText().toString();
//
//                 if(a != b){
//                     Cnumber2.setError("invalid Card number entered");
//                     Cnumber2.requestFocus();
//                     return;
//                 }
//
//                 if(!g.contentEquals(h)){
//                     date.setError("invalid expire date");
//                     date.requestFocus();
//                     return;
//                 }
//                 if(e != f){
//                     Ccvv4.setError("invalid cvv entered");
//                     Ccvv4.requestFocus();
//                     return;
//                 }
//                 else {
//                     t12.setVisibility(View.VISIBLE);
//
//                     String s1 = Cname3.getText().toString();
//
//                     check.child(s1).addValueEventListener(new ValueEventListener() {
//                         @Override
//                         public void onDataChange(@NonNull DataSnapshot snapshot) {
//                             int a1 = Integer.parseInt(ett9.getText().toString());
//                             int a2 = Integer.parseInt(tbal4.getText().toString());
//                             int a3 = a1 + a2;
//                             result1.setText(String.valueOf(a3));
//                             Map<String, Object> hashMap = new HashMap<>();
//                             hashMap.put("account balance", result1);
//                             snapshot.getRef().updateChildren(hashMap);
//                         }
//
//                         @Override
//                         public void onCancelled(@NonNull DatabaseError error) {
//
//                         }
//                     });
//                     String s2 = et1.getText().toString();
//                     check2.child(s2).addValueEventListener(new ValueEventListener() {
//                         @Override
//                         public void onDataChange(@NonNull DataSnapshot snapshot) {
//
////                             Map<String, Object> hashMap = new HashMap<>();
////                             hashMap.put("accountBalance", result2);
////                             snapshot.getRef().updateChildren(hashMap);
//
//                         }
//
//                         @Override
//                         public void onCancelled(@NonNull DatabaseError error) {
//
//                         }
//                     });
//                     String s3 = ett8.getText().toString();
//                     check3.child(s3).addValueEventListener(new ValueEventListener() {
//                         @Override
//                         public void onDataChange(@NonNull DataSnapshot snapshot) {
//                             int a1 = Integer.parseInt(ett11.getText().toString());
//                             int a2 = Integer.parseInt(t7.getText().toString());
//                             int a3 = a1 + a2;
//                             result3.setText(String.valueOf(a3));
////                             Map<String, Object> hashMap = new HashMap<>();
////                             hashMap.put("accountBalance", result3);
////                             snapshot.getRef().updateChildren(hashMap);
//                         }
//
//                         @Override
//                         public void onCancelled(@NonNull DatabaseError error) {
//
//                         }
//                     });
//                 }
//
//             }
//         });
//         t12.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//
//                 check.child(s1).addValueEventListener(new ValueEventListener() {
//                     @Override
//                     public void onDataChange(@NonNull DataSnapshot snapshot) {
//                         int a1 = Integer.parseInt(ett9.getText().toString());
//                         int a2 = Integer.parseInt(tbal4.getText().toString());
//                         int a3 = a1 + a2;
//                         result1.setText(String.valueOf(a3));
//                         Map<String, Object> hashMap = new HashMap<>();
//                         hashMap.put("account balance", result1);
//                         snapshot.getRef().updateChildren(hashMap);
//                     }
//
//                     @Override
//                     public void onCancelled(@NonNull DatabaseError error) {
//
//                     }
//                 });
//
//
//                 check2.child(s2).addValueEventListener(new ValueEventListener() {
//                     @Override
//                     public void onDataChange(@NonNull DataSnapshot snapshot) {
//                         int a1 = Integer.parseInt(ett10.getText().toString());
//                         int a2 = Integer.parseInt(tv6.getText().toString());
//                         int a3 = a1 + a2;
//                         result2.setText(String.valueOf(a3));
//                         String sa = result2.getText().toString();
//                         Map<String, Object> hashMap = new HashMap<>();
//                         hashMap.put("accountBalance", sa);
//                         snapshot.getRef().updateChildren(hashMap);
//                     }
//
//                     @Override
//                     public void onCancelled(@NonNull DatabaseError error) {
//
//                     }
//                 });
//
//                 check3.child(s3).addValueEventListener(new ValueEventListener() {
//                     @Override
//                     public void onDataChange(@NonNull DataSnapshot snapshot) {
//                         int a1 = Integer.parseInt(ett11.getText().toString());
//                         int a2 = Integer.parseInt(t7.getText().toString());
//                         int a3 = a1 + a2;
//                         result3.setText(String.valueOf(a3));
//                         Map<String, Object> hashMap = new HashMap<>();
//                         hashMap.put("customerBill", result3);
//                         snapshot.getRef().updateChildren(hashMap);
//                     }
//
//                     @Override
//                     public void onCancelled(@NonNull DatabaseError error) {
//
//                     }
//                 });
//             }
//         });

    }
}