package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class masm extends AppCompatActivity {
    Button mcredit, mdebit;
    EditText anmt, refnum;
    TextView mazm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masm);
        mcredit = (Button)findViewById(R.id.btn6);
        mdebit = (Button)findViewById(R.id.btn2);
        anmt = (EditText)findViewById(R.id.masamount);
        refnum = (EditText)findViewById(R.id.masmita);
        mazm = (TextView)findViewById(R.id.txv7);

        mcredit.setOnClickListener(new View.OnClickListener() {
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
                    refnum.setError("please fill in reference number ");
                    refnum.requestFocus();
                    return;
                }
                Intent intent = new Intent(masm.this, CardForm.class);
                startActivity(intent);
            }
        });

        mdebit.setOnClickListener(new View.OnClickListener() {
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
                    refnum.setError("please fill in reference number ");
                    refnum.requestFocus();
                    return;
                }
                String s1 = anmt.getText().toString();
                String s2 = mazm.getText().toString();
                String s3 = refnum.getText().toString();
                Intent intent = new Intent(masm.this, debitCard.class);
                intent.putExtra("anmt", s1);
                intent.putExtra("set", s2);
                intent.putExtra("sett", s3);
                startActivity(intent);
            }
        });
    }
}