package com.example.testui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Test2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        Button button5=findViewById(R.id.button5);
        LayoutInflater inflater=Test2.this.getLayoutInflater();
        View v= inflater.inflate(R.layout.activity_test2_1,null,false);
        Context context=Test2.this;
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setView(v);
        builder.setCancelable(false);
        final AlertDialog alertDialog=builder.create();
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();
            }
        });
        v.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Test2.this,"NO",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        v.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Test2.this,"YES",Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
    }
}
