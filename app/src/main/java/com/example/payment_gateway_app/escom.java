package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class escom extends AppCompatActivity {
Button Ecredit, Edebit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escom);
        Ecredit = (Button) findViewById(R.id.btn7);
        Edebit = (Button) findViewById(R.id.cont1);


        Ecredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(escom.this, CardForm.class);
                startActivity(intent);
            }
        });
        Edebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(escom.this, debitCard.class);
                startActivity(intent);
            }
        });
    }
}