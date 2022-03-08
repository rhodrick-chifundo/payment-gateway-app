package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class universityfees extends AppCompatActivity {
Button ucredit, udebit;
   EditText anmt, idnam;
   TextView fee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universityfees);

        ucredit = (Button)findViewById(R.id.btn10);
        udebit = (Button)findViewById(R.id.btn3);
        anmt = (EditText)findViewById(R.id.feeAmount);
        idnam = (EditText)findViewById(R.id.idnum);
        fee = (TextView)findViewById(R.id.txv9);

        ucredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Wamount = anmt.getText().toString();
                if(TextUtils.isEmpty(Wamount)){
                    anmt.setError("please fill in amount ");
                    anmt.requestFocus();
                    return;
                }
                String reff = idnam.getText().toString();
                if(TextUtils.isEmpty(reff)){
                    idnam.setError("please fill in your ID number ");
                    idnam.requestFocus();
                    return;
                }
                Intent intent = new Intent(universityfees.this, CardForm.class);
                String s1 = anmt.getText().toString();
                String s2 = fee.getText().toString();
                String s3 = idnam.getText().toString();
                intent.putExtra("anmt1", s1);
                intent.putExtra("set1", s2);
                intent.putExtra("sett1", s3);
                startActivity(intent);
            }
        });

        udebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Wamount = anmt.getText().toString();
                if(TextUtils.isEmpty(Wamount)){
                    anmt.setError("please fill in amount ");
                    anmt.requestFocus();
                    return;
                }
                String reff = idnam.getText().toString();
                if(TextUtils.isEmpty(reff)){
                    idnam.setError("please fill in your ID number ");
                    idnam.requestFocus();
                    return;
                }
                Intent intent = new Intent(universityfees.this, debitCard.class);
                String s1 = anmt.getText().toString();
                String s2 = fee.getText().toString();
                String s3 = idnam.getText().toString();
                intent.putExtra("anmt", s1);
                intent.putExtra("set", s2);
                intent.putExtra("sett", s3);
                startActivity(intent);

            }
        });

    }
}