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

    String s1;
    EditText anmt, refnum;
    TextView meth1;

    Button cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masm);
        anmt = (EditText)findViewById(R.id.masamount);
        refnum = (EditText)findViewById(R.id.masmita);
        meth1 = (TextView)findViewById(R.id.mmetch1);
        cont = (Button)findViewById(R.id.bbb);


        s1 = getIntent().getExtras().getString("ment");
        meth1.setText(s1);

      cont.setOnClickListener(new View.OnClickListener() {
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

                Intent intent = new Intent(masm.this, CredeptCard.class);
//                String s1 = anmt.getText().toString();
//                String s2 = meth1.getText().toString();
//                String s3 = refnum.getText().toString();
//                intent.putExtra("anmt1", s1);
//                intent.putExtra("set1", s2);
//                intent.putExtra("sett1", s3);
//                startActivity(intent);
//                anmt.setText("");
//                refnum.setText("");
            }
        });

    }
}