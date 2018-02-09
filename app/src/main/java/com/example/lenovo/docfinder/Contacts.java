package com.example.lenovo.docfinder;

/**
 * Created by Lenovo on 10/30/2017.
 */

public class Contacts {
    private String name, email,mobileno;

    public Contacts(String name, String mobileno) {
        this.setName(name);
        this.setMobileno(mobileno);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }


}