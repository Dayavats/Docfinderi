package com.example.lenovo.docfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Lenovo on 9/27/2017.
 */

public class Signin extends Activity {
    EditText Username,password;
    Button register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        Username = (EditText) findViewById(R.id.UserName);
        password = (EditText) findViewById(R.id.Password);
        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signin.this,Register.class);
                startActivity(intent);
            }
        });
    }

    public void Login(View view){

        String username = Username.getText().toString();
        String Password = password.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,Password);


    }
    public void register(View view){
        Intent intent=new Intent(this, Register.class);
        startActivity(intent);

    }

}