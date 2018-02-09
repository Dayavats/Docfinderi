package com.example.lenovo.docfinder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Register extends Activity {

    EditText name,username,password,spaciality,address,qualification,phoneNo;
    String Name,Username,Password,Spaciality,Address,Qualification,PhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name =(EditText) findViewById(R.id.Name);
        username =(EditText) findViewById(R.id.UserName);
        password =(EditText) findViewById(R.id.Password);
        spaciality =(EditText) findViewById(R.id.speciality);
        address =(EditText) findViewById(R.id.address);
        qualification =(EditText) findViewById(R.id.qualification);
        phoneNo =(EditText) findViewById(R.id.Phone_no);





    }

    public void Register(View view){

        Name = name.getText().toString();
        Username = username.getText().toString();
        Password = password.getText().toString();
        Spaciality = spaciality.getText().toString();
        Address = address.getText().toString();
        Qualification = qualification.getText().toString();
        PhoneNo = phoneNo.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, Name, Username, Password, Spaciality, Address, Qualification, PhoneNo);

    }
}
