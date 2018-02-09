package com.example.lenovo.docfinder;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

     Button docbtn;
        Button patnbtn;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            docbtn = (Button) findViewById(R.id.dcbtn);
            patnbtn = (Button) findViewById(R.id.patbtn);
            docbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Signin.class);
                    startActivity(intent);
                }
            });
            patnbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,Doctorlist.class);
                    startActivity(intent);
                }
            });
        }

    }





