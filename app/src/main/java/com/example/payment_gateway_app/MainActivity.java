package com.example.payment_gateway_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button go;
    EditText mechant;
    TextView add, Register1;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = (Button)findViewById(R.id.bba);
        mechant = (EditText)findViewById(R.id.tvc1);
        add = (TextView) findViewById(R.id.reg1);
        Register1 = (TextView) findViewById(R.id.custma);
         add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, RegisterSivice.class);
                 startActivity(intent);
             }
         });
         Register1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, AddCustomers.class);
                 startActivity(intent);
             }
         });
         go.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String mennt = mechant.getText().toString();
                 if(TextUtils.isEmpty(mennt)){
                     mechant.setError("type or select merchant on the list");
                     mechant.requestFocus();
                     return;
                 }
                 Intent intent = new Intent(MainActivity.this, CredeptCard.class);
                 String s1 = mechant.getText().toString();
                 intent.putExtra("ment", s1);
                 mechant.setText("");
                 startActivity(intent);

             }
         });
    }
}