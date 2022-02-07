package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class waterboard extends AppCompatActivity {
    Button Wcredit, Wdebit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterboard);
        Wcredit = (Button) findViewById(R.id.btn1);
        Wdebit = (Button) findViewById(R.id.btn5);

        Wcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(waterboard.this, CardForm.class);
                startActivity(intent);
            }
        });
        Wdebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(waterboard.this, debitCard.class);
                startActivity(intent);
            }
        });

    }
}