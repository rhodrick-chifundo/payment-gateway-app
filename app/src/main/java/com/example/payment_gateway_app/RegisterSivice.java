package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterSivice extends AppCompatActivity {
    EditText Svname, Sbankaname, Sbanknum, SvUname;
    EditText Sname, Cname, Crefnumber, CasBill;
    TextView Svbalance;
    Button submit1, submit2;
    FirebaseDatabase database;
    DatabaseReference check, check2, check3, check4;

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
        submit2 = (Button) findViewById(R.id.sed);

        Sname = (EditText)findViewById(R.id.SrvName);
        Cname = (EditText)findViewById(R.id.Caname);
        Crefnumber = (EditText)findViewById(R.id.rreffunm);
        CasBill = (EditText)findViewById(R.id.Cbill);


        database = FirebaseDatabase.getInstance();
        check = database.getReference("BANK").child("OLDINALLY CUSTOMERS");
        check3 = database.getReference("MERCHANTS CUSTOMERS");
        check2 = database.getReference("BANK").child("MERCHANTS");


        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String accountBalance = Svbalance.getText().toString();
              String accountName = SvUname.getText().toString();
              String accountNumber = Sbanknum.getText().toString();
              String serviceName = Svname.getText().toString();
                merchants merchants1 = new merchants(accountBalance, accountName, accountNumber, serviceName);
                merchants2 merchantsa = new merchants2(serviceName);
                check2.child(serviceName).setValue(merchants1);
                check3.child(serviceName).setValue(merchantsa);

            }
        });

        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String serviceName = Sname.getText().toString();
                String customerName = Cname.getText().toString();
                String referenceNumber = Crefnumber.getText().toString();
                String customerBill = CasBill.getText().toString();
                check4 = database.getReference("MERCHANTS CUSTOMERS").child(serviceName);
                customers customers1 = new customers(serviceName, customerName, referenceNumber, customerBill);
                check4.child(referenceNumber).setValue(customers1);

            }
        });
    }
}






