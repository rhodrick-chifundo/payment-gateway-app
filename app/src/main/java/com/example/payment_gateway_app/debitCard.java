package com.example.payment_gateway_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.HashMap;
import java.util.Map;

public class debitCard extends AppCompatActivity {
    int a1, a2, c1;
    String number, number2, number3, s, s1, s2, s3;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12,t13,t14,t15;
    TextView res1,res2,res3;
    EditText et1, et2, et3, et4, et5, et6,et7, et8;
    Button btn1, btn2, add;
    FirebaseDatabase database, database1;
    DatabaseReference check, check2, check3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card);

        t1 = (TextView)findViewById(R.id.tvc);
        t2 = (TextView)findViewById(R.id.tvd);
        t3 = (TextView)findViewById(R.id.tve);
        t4 = (TextView)findViewById(R.id.tvf);
        t5 = (TextView)findViewById(R.id.tvg);
        t6 = (TextView)findViewById(R.id.tvh);
        t7 = (TextView)findViewById(R.id.tvj);
        t8 = (TextView)findViewById(R.id.tvk);
        t9 = (TextView)findViewById(R.id.test);
        t10 = (TextView)findViewById(R.id.tvxa);
        t11 = (TextView)findViewById(R.id.tvb);
        t12 = (EditText)findViewById(R.id.tvi);
        t13 = (TextView)findViewById(R.id.bal);
        t14 = (TextView)findViewById(R.id.Mbal);
        t15 = (TextView)findViewById(R.id.Cbal);
        res1 = (TextView)findViewById(R.id.rezz1);
        res2 = (TextView)findViewById(R.id.rezz2);
        res3 = (TextView)findViewById(R.id.rezz3);
        btn1 = (Button)findViewById(R.id.btn11);
        btn2 = (Button)findViewById(R.id.btn13);


        et1 = (EditText)findViewById(R.id.Dnumber);
        et2 = (EditText)findViewById(R.id.dccv);
        et3 = (EditText)findViewById(R.id.Dname);
        et4 = (EditText)findViewById(R.id.Dday);
        et5 = (EditText)findViewById(R.id.Dmonth);
        et6 = (EditText)findViewById(R.id.Dyear);
        et7 = (EditText)findViewById(R.id.Ccbal);







            s1 = getIntent().getExtras().getString("anmt");
            t10.setText(s1);
            s2 = getIntent().getExtras().getString("set");
            t12.setText(s2);
            s3 = getIntent().getExtras().getString("sett");
            et7.setText(s3);

        database = FirebaseDatabase.getInstance();
        check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check2 = database.getReference("BANK").child("MERCHANTS");
        check3 = database.getReference("MERCHANTS CUSTOMERS");



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = et3.getText().toString();

                number3 = et7.getText().toString();

                check.child(number).addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        String Cnumber = snapshot.child("card number").getValue().toString();
                        String Cname = snapshot.child("account name").getValue().toString();
                        String cvv1 = snapshot.child("cvv").getValue().toString();
                        String Cday = snapshot.child("day").getValue().toString();
                        String mont = snapshot.child("month").getValue().toString();
                        String year = snapshot.child("year").getValue().toString();
                        String Anumber = snapshot.child("account number").getValue().toString();
                        String balance = snapshot.child("account balance").getValue().toString();


                        et1.setText(Cnumber);
                        t1.setText(Cnumber);
                        t2.setText(Cname);
                        t3.setText(cvv1);
                        t4.setText(Cday);
                        t5.setText(mont);
                        t6.setText(year);
                        t11.setText(Anumber);
                        t13.setText(balance);


                        String w = et3.getText().toString();
                        String t = t2.getText().toString();

                        int n = Integer.parseInt(t5.getText().toString());
                        int m = Integer.parseInt(et5.getText().toString());

                        long a = Long.parseLong(et1.getText().toString());
                        long e = Long.parseLong(t1.getText().toString());

                        int b = Integer.parseInt(et2.getText().toString());
                        int f = Integer.parseInt(t3.getText().toString());

                        int c = Integer.parseInt(et4.getText().toString());
                        int g = Integer.parseInt(t4.getText().toString());

                        int d = Integer.parseInt(et6.getText().toString());
                        int h = Integer.parseInt(t6.getText().toString());

                        int r = Integer.parseInt(t11.getText().toString());
                        int q = Integer.parseInt(t10.getText().toString());
                        int p = Integer.parseInt(t13.getText().toString());


                        if (a != e || b != f || c != g || d != h || n != m ) {

                            Toast.makeText(debitCard.this, "you are not a valid customer!", Toast.LENGTH_LONG).show();

                        }
                      else if(q > p){
                            Toast.makeText(debitCard.this, "sorry you have insufficient balance", Toast.LENGTH_LONG).show();
                        }

                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                
                number2 = t12.getText().toString();
                    check2.child(number2).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String balance = snapshot.child("account balance").getValue().toString();
                            t14.setText(balance);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                check3.child(number2).child(number3).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String bil = snapshot.child("bill").getValue().toString();
                        t15.setText(bil);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }


        });




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int b = Integer.parseInt(t13.getText().toString());
                int b1 = Integer.parseInt(t14.getText().toString());
                int b2 = Integer.parseInt(t15.getText().toString());

                check.child(number).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int a = Integer.parseInt(t10.getText().toString());
                        int c = b - a;
                        res1.setText(String.valueOf(c));
                        String p = res1.getText().toString();
                            Map<String, Object> hashMap = new HashMap<>();
                            hashMap.put("account balance", p);
                            snapshot.getRef().updateChildren(hashMap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                check2.child(number2).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int a = Integer.parseInt(t10.getText().toString());
                        int c = a + b1;
                        res2.setText(String.valueOf(c));
                        int p = Integer.parseInt(res2.getText().toString());
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("account balance", p);
                        snapshot.getRef().updateChildren(hashMap);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                check3.child(number2).child(number3).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int a = Integer.parseInt(t10.getText().toString());
                        int c = b2 - a;
                        res3.setText(String.valueOf(c));
                        int p = Integer.parseInt(res3.getText().toString());
                        Map<String, Object> hashMap = new HashMap<>();
                        hashMap.put("bill", p);
                        snapshot.getRef().updateChildren(hashMap);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}