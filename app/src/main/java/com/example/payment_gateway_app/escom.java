package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class escom extends AppCompatActivity {
Button Ecredit, Edebit;
    EditText anmt, refnum;
    TextView escon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escom);
        Ecredit = (Button) findViewById(R.id.btn7);
        Edebit = (Button) findViewById(R.id.cont1);
        anmt = (EditText)findViewById(R.id.escamnt);
        refnum = (EditText)findViewById(R.id.escmit);
        escon = (TextView)findViewById(R.id.txv3);


        Ecredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reff = refnum.getText().toString();
                if(TextUtils.isEmpty(reff)){
                    refnum.setError("please fill in meter number number ");
                    refnum.requestFocus();
                    return;
                }
                String Wamount = anmt.getText().toString();
                if(TextUtils.isEmpty(Wamount)){
                    anmt.setError("please fill in amount ");
                    anmt.requestFocus();
                    return;
                }
                Intent intent= new Intent(escom.this, CardForm.class);
                startActivity(intent);
            }
        });
        Edebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reff = refnum.getText().toString();
                if(TextUtils.isEmpty(reff)){
                    refnum.setError("please fill in meter number number ");
                    refnum.requestFocus();
                    return;
                }
                String Wamount = anmt.getText().toString();
                if(TextUtils.isEmpty(Wamount)){
                    anmt.setError("please fill in amount ");
                    anmt.requestFocus();
                    return;
                }
                Intent intent= new Intent(escom.this, debitCard.class);
                String s1 = anmt.getText().toString();
                String s2 = escon.getText().toString();
                String s3 = refnum.getText().toString();
                intent.putExtra("anmt", s1);
                intent.putExtra("set", s2);
                intent.putExtra("sett", s3);
                startActivity(intent);
            }
        });
    }
}