package com.example.nived.e_governance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Timer().schedule(new TimerTask(){
            public void run(){
                startActivity(new Intent(MainActivity.this,HomePage.class));
            }
        },1000);
    }
}
