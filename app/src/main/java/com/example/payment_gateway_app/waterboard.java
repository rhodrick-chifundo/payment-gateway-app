package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class waterboard extends AppCompatActivity {
    Button Wcredit, Wdebit;
    EditText anmt, refnum;
    TextView waterb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterboard);
        Wcredit = (Button) findViewById(R.id.btn5);
        Wdebit = (Button) findViewById(R.id.btn1);
      anmt = (EditText)findViewById(R.id.wamount);
      refnum = (EditText)findViewById(R.id.wmitnum);
      waterb = (TextView)findViewById(R.id.txv5);

        Wcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Wamount = anmt.getText().toString();
                if(TextUtils.isEmpty(Wamount)){
                    anmt.setError("please fill in amount ");
                    anmt.requestFocus();
                    return;
                }
                String reff = refnum.getText().toString();
                if(TextUtils.isEmpty(reff)){
                    refnum.setError("please fill in meter number ");
                    refnum.requestFocus();
                    return;
                }
                Intent intent =  new Intent(waterboard.this, CardForm.class);
                startActivity(intent);
            }
        });
        Wdebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reff = refnum.getText().toString();
                if(TextUtils.isEmpty(reff)){
                    refnum.setError("please fill in meter number ");
                    refnum.requestFocus();
                    return;
                }
                String Wamount = anmt.getText().toString();
                if(TextUtils.isEmpty(Wamount)){
                    anmt.setError("please fill in amount ");
                    anmt.requestFocus();
                    return;
                }
                String s1 = anmt.getText().toString();
                String s2 = waterb.getText().toString();
                String s3 = refnum.getText().toString();
                Intent intent =  new Intent(waterboard.this, debitCard.class);
                intent.putExtra("anmt", s1);
                intent.putExtra("set", s2);
                intent.putExtra("sett", s3);
                startActivity(intent);
            }
        });

    }
}