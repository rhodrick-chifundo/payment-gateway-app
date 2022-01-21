package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button escom, waterb, masm, malawih, fees;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waterb = (Button)findViewById(R.id.waterb);
        masm = (Button)findViewById(R.id.masm);
        escom = (Button)findViewById(R.id.escom);
        malawih= (Button)findViewById(R.id.malawih);
        fees = (Button)findViewById(R.id.fees);
         waterb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, waterboard.class);
                 startActivity(intent);
             }
         });
         masm.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, masm.class);
                 startActivity(intent);
             }
         });
         escom.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, escom.class);
                 startActivity(intent);
             }
         });
         malawih.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, malawihousing.class);
                 startActivity(intent);
             }
         });
         fees.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, universityfees.class);
                 startActivity(intent);
             }
         });
    }
}