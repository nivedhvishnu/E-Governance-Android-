package com.example.nived.e_governance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
    Button login,user_registration,manager_registration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        login=(Button) findViewById(R.id.login_button);
        user_registration=(Button) findViewById(R.id.user_registration_button);
        manager_registration=(Button) findViewById(R.id.manager_registration_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,LoginPage.class));
            }
        });

        user_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,UserRegistration.class));
            }
        });

        manager_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this,ManagerRegistration.class));
            }
        });
    }
}
