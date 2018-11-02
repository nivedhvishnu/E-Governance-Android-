package com.example.nived.e_governance;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

public class UserRegistration extends AppCompatActivity {
    Button register,exit;
    EditText name,username,password,password1,email,contact;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        register=(Button)findViewById(R.id.register);
        exit=(Button)findViewById(R.id.exit_button);
        name=(EditText)findViewById(R.id.name);
        username=(EditText)findViewById(R.id.user_name);
        password=(EditText)findViewById(R.id.password);
        password1=(EditText)findViewById(R.id.confirm_password);
        email=(EditText)findViewById(R.id.email);
        contact=(EditText)findViewById(R.id.contact);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserRegistration.this,HomePage.class));
            }
        });
        db=openOrCreateDatabase("Users",Context.MODE_PRIVATE,null);
        db.execSQL("create table if not exists user(name varchar,username varchar,password varchar,email varchar,mobile varchar);");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().length()==0||
                        username.getText().toString().trim().length()==0||
                        password.getText().toString().trim().length()==0||
                        email.getText().toString().trim().length()==0||
                        contact.getText().toString().trim().length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Enter All the fields",Toast.LENGTH_SHORT).show();
                    return;
                }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
                {
                    Toast.makeText(UserRegistration.this,"Enter Proper Email ID", Toast.LENGTH_SHORT).show();
                    return;
                }else if(contact.getText().toString().trim().length()!=10)
                {
                    Toast.makeText(getApplicationContext(),"Enter all 10 digits no",Toast.LENGTH_SHORT).show();
                }
                db.execSQL("insert into user values('"+name.getText()+"','"+username.getText()+"','"+password.getText()+"','"+email.getText()+"','"+contact.getText()+"');");
                Toast.makeText(getApplicationContext(),"Registration Successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserRegistration.this,HomePage.class));
                clear();
            }
        });
    }

    public void clear(){
        username.setText("");
        name.setText("");
        password1.setText("");
        password.setText("");
        email.setText("");
        contact.setText("");
    }
}
