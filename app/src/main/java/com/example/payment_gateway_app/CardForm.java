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

public class CardForm extends AppCompatActivity {
    String number1, number2, number3, s1,s2,s3;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    EditText et1,et2,et3, et4, et5, et6, et7, et8, et9, et10;
    Button btna;
    FirebaseDatabase database;
    DatabaseReference check, check2, check3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_form);
        t1 = (TextView)findViewById(R.id.tv1);
        t2 = (TextView)findViewById(R.id.tv2);
        t3 = (TextView)findViewById(R.id.tv3);
        t4 = (TextView)findViewById(R.id.tv4);
        t5 = (TextView)findViewById(R.id.tv5);
        t6 = (TextView)findViewById(R.id.tv6);
        t7 = (TextView)findViewById(R.id.tv7);
        t8 = (TextView)findViewById(R.id.tv8);
        t9 = (TextView)findViewById(R.id.tv9);
        t10 = (TextView)findViewById(R.id.tv10);
        t11 = (TextView)findViewById(R.id.tv11);
        t12 = (TextView)findViewById(R.id.tv12);

        btna = (Button)findViewById(R.id.btn14);


        et1 = (EditText)findViewById(R.id.ett1);
        et2 = (EditText)findViewById(R.id.ett2);
        et3 = (EditText)findViewById(R.id.ett3);
        et4 = (EditText)findViewById(R.id.Cnumber);
        et5 = (EditText)findViewById(R.id.ccv);
        et6 = (EditText)findViewById(R.id.Cname);
        et7 = (EditText)findViewById(R.id.Cday);
        et8 = (EditText)findViewById(R.id.Cmonth);
        et9 = (EditText)findViewById(R.id.Cyear);



        s1 = getIntent().getExtras().getString("anmt1");
        et1.setText(s1);
        s2 = getIntent().getExtras().getString("set1");
        et2.setText(s2);
        s3 = getIntent().getExtras().getString("sett1");
        et3.setText(s3);


        database = FirebaseDatabase.getInstance();
        check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check2 = database.getReference("BANK").child("MERCHANTS");
        check3 = database.getReference("MERCHANTS CUSTOMERS");
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = et6.getText().toString();     // oldinally customers
                number2 = et2.getText().toString();     // merchnts in bank
                number3 = et3.getText().toString();      // merchants book


                check.child(number1).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String Cnumber = snapshot.child("card number").getValue().toString();
                        String cvv1 = snapshot.child("cvv").getValue().toString();
                        String Cday = snapshot.child("day").getValue().toString();
                        String mont = snapshot.child("month").getValue().toString();
                        String year = snapshot.child("year").getValue().toString();
                        String balance = snapshot.child("account balance").getValue().toString();
                        t1.setText(Cnumber);
                        t2.setText(cvv1);
                        t3.setText(Cday);
                        t4.setText(mont);
                        t5.setText(year);
                        t6.setText(balance);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                check2.child(number2).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String balance = snapshot.child("account balance").getValue().toString();
                        t7.setText(balance);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                check3.child(number2).child(number3).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String bil = snapshot.child("bill").getValue().toString();
                        t8.setText(bil);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}