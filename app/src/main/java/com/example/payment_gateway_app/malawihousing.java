package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class malawihousing extends AppCompatActivity {
    Button hcredit, hdebit;
    EditText anmt, refnum;
    TextView housing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malawihousing);
        hcredit = (Button)findViewById(R.id.btn4);
        hdebit = (Button)findViewById(R.id.btn12);
        anmt = (EditText)findViewById(R.id.hamnt);
        refnum = (EditText)findViewById(R.id.hmetr);
        housing = (TextView)findViewById(R.id.txv1);

        hcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reff = refnum.getText().toString();
                if(TextUtils.isEmpty(reff)){
                    refnum.setError("please fill in reference number ");
                    refnum.requestFocus();
                    return;
                }
                Intent intent = new Intent(malawihousing.this, CardForm.class);
                String ss1 = anmt.getText().toString();
                String ss2 = housing.getText().toString();
                String ss3 = refnum.getText().toString();
                intent.putExtra("anmt1", ss1);
                intent.putExtra("set1", ss2);
                intent.putExtra("sett1", ss3);
                startActivity(intent);
            }
        });

        hdebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Wamount = anmt.getText().toString();
                if(TextUtils.isEmpty(Wamount)){
                    anmt.setError("please fill in amount ");
                    anmt.requestFocus();
                    return;
                }
                Intent intent = new Intent(malawihousing.this, debitCard.class);
                String s1 = anmt.getText().toString();
                String s2 = housing.getText().toString();
                String s3 = refnum.getText().toString();
                intent.putExtra("anmt", s1);
                intent.putExtra("set", s2);
                intent.putExtra("sett", s3);
                startActivity(intent);
            }
        });
    }
}