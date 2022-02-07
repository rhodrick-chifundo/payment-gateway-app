package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class masm extends AppCompatActivity {
    Button mcredit, mdebit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masm);
        mcredit = (Button)findViewById(R.id.btn6);
        mdebit = (Button)findViewById(R.id.btn2);

        mcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masm.this, CardForm.class);
                startActivity(intent);
            }
        });

        mdebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masm.this, debitCard.class);
                startActivity(intent);
            }
        });
    }
}