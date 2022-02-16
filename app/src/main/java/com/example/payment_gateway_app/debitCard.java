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

public class debitCard extends AppCompatActivity {
    String number;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    EditText et1, et2, et3, et4, et5, et6;
    Button btn1;
    FirebaseDatabase database;
    DatabaseReference check;
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
        btn1 = (Button)findViewById(R.id.btn11);

        et1 = (EditText)findViewById(R.id.Dnumber);
        et2 = (EditText)findViewById(R.id.dccv);
        et3 = (EditText)findViewById(R.id.Dname);
        et4 = (EditText)findViewById(R.id.Dday);
        et5 = (EditText)findViewById(R.id.Dmonth);
        et6 = (EditText)findViewById(R.id.Dyear);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
                number = et3.getText().toString();
                check.child(number).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String Cnumber = snapshot.child("card number").getValue().toString();
                        String Cname = snapshot.child("account name").getValue().toString();
                        String cvv1 = snapshot.child("cvv").getValue().toString();
                        String Cday = snapshot.child("day").getValue().toString();
                        String mont = snapshot.child("month").getValue().toString();
                        String year = snapshot.child("year").getValue().toString();

                        t1.setText(Cnumber);
                        t2.setText(Cname);
                        t3.setText(cvv1);
                        t4.setText(Cday);
                        t5.setText(mont);
                        t6.setText(year);

                       int a = Integer.parseInt(et4.getText().toString());
                        int e = Integer.parseInt(t4.getText().toString());
                      int b = Integer.parseInt(et2.getText().toString());
                       int c = Integer.parseInt(et4.getText().toString());
                       int d = Integer.parseInt(et6.getText().toString());


                       int f = Integer.parseInt(t3.getText().toString());
                      int g = Integer.parseInt(t4.getText().toString());
                       int h = Integer.parseInt(t6.getText().toString());

                        if(a != e || b != f || c != g || d != h){
                            t9.setText(" the user is not valid");
                        }
                        else {

                            t9.setText(" the user is valid");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}