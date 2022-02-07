package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class universityfees extends AppCompatActivity {
Button ucredit, udebit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universityfees);

        ucredit = (Button)findViewById(R.id.btn10);
        udebit = (Button)findViewById(R.id.btn3);
        ucredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(universityfees.this, CardForm.class);
                startActivity(intent);
            }
        });

        udebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(universityfees.this, debitCard.class);
                startActivity(intent);
            }
        });
    }
}