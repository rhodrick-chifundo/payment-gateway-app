package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class malawihousing extends AppCompatActivity {
    Button hcredit, hdebit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malawihousing);
        hcredit = (Button)findViewById(R.id.btn12);
        hdebit = (Button)findViewById(R.id.btn4);

        hcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(malawihousing.this, CardForm.class);
                startActivity(intent);
            }
        });

        hdebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(malawihousing.this, debitCard.class);
                startActivity(intent);
            }
        });
    }
}