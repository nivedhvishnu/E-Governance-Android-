package com.example.nived.e_governance;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class ManagerRegistration extends AppCompatActivity {
    Button register,exit;
    EditText manager_name,username,password,password1;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_registration);
        register=(Button)findViewById(R.id.register);
        exit=(Button)findViewById(R.id.exit_button);
        manager_name=(EditText)findViewById(R.id.name);
        username=(EditText)findViewById(R.id.user_name);
        password=(EditText)findViewById(R.id.password);
        password1=(EditText)findViewById(R.id.confirm_password);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManagerRegistration.this,HomePage.class));
            }
        });
        db=openOrCreateDatabase("Managers",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        db.execSQL("create table if not exists manager(manager_name varchar,username varchar,password varchar);");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(manager_name.getText().toString().trim().length()==0||username.getText().toString().trim().length()==0||
                        password.getText().toString().trim().length()==0||password1.getText().toString().trim().length()==0){
                    Toast.makeText(ManagerRegistration.this,"Enter All Feilds",Toast.LENGTH_SHORT).show();
                }else if(!password.getText().toString().trim().equals(password1.getText().toString().trim())){
                    Toast.makeText(ManagerRegistration.this,"Passwords don't match",Toast.LENGTH_SHORT).show();
                }
                db.execSQL("insert into manager values('"+manager_name.getText()+"','"+username.getText()+"','"+password.getText()+"');");
                Toast.makeText(ManagerRegistration.this,"Registration Sucessfull",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ManagerRegistration.this,HomePage.class));
                clear();
            }
        });
    }

    public void clear(){
        manager_name.setText("");
        username.setText("");
        password.setText("");
        password1.setText("");
    }
}
