package com.example.nived.e_governance;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.app.ProgressDialog;

public class LoginPage extends AppCompatActivity {
    EditText username,password;
    Button login,exit;
    String u,p;
    SQLiteDatabase db;
   // Data d = (Data)getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password_feild);
        login = (Button) findViewById(R.id.signin_button);
        exit = (Button) findViewById(R.id.exit_button);

        exit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this, HomePage.class));
            }
        });

        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("") || password.getText().toString().equals("")) {

                    Toast.makeText(LoginPage.this, "Please enter all the fields..!", Toast.LENGTH_LONG).show();
                } else {
                    u = username.getText().toString();
                    p = password.getText().toString();
                    try {
                        db = openOrCreateDatabase("Users", SQLiteDatabase.CREATE_IF_NECESSARY, null);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    try {


                        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                            Toast.makeText(LoginPage.this, "Welcome To Admin Home Page " + u, Toast.LENGTH_LONG).show();
                            //  d.Setusername(username.getText().toString().trim());
                            // d.Setpassword(password.getText().toString().trim());
                            Intent a = new Intent(LoginPage.this, AdminPage.class);
                            startActivity(a);
                            clear();
                            return;
                        }
                        Cursor cc = db.rawQuery("select * from user where username= '" + u + "' and password= '" + p + "' ", null);
                        if (cc.moveToFirst()) {
                            String temp = "";
                            if (cc != null) {
                                if (cc.getCount() > 0) {
                                    //return true;
                                    scan g = new scan();
                                    g.execute();

                                    Toast.makeText(LoginPage.this, "Welcome To User HomePage ", Toast.LENGTH_LONG).show();
                                    //       d.Setusername(username.getText().toString().trim());
                                    //     d.Setpassword(password.getText().toString().trim());
                                    Intent b = new Intent(LoginPage.this, UserPage.class);
                                    startActivity(b);
                                    clear();
                                    return;
                                }
                            }
                        }
                        try{
                            db= openOrCreateDatabase("Managers",SQLiteDatabase.CREATE_IF_NECESSARY,null);
                        }catch(Exception e){
                            e.printStackTrace();
                        }

                        Cursor cc2 = db.rawQuery("select * from manager where username= '"+u+"' and password= '"+p+"' ", null);
                        if(cc2.moveToFirst()){
                            String temp="";
                            if (cc2 != null) {
                                if(cc2.getCount() > 0){
                                    //return true;
                                    scan g=new scan();
                                    g.execute();
                                    Toast.makeText(LoginPage.this, "Welcome To Manager Home Page ", Toast.LENGTH_LONG).show();
                                    //globalvariabel.Setusername(user.getText().toString().trim());
                                    //globalvariabel.Setpassword(pass.getText().toString().trim());
                                    Intent c = new Intent(LoginPage.this,ManagerPage.class);
                                    startActivity(c);
                                    clear();
                                    return;
                                }else{
                                    Toast.makeText(LoginPage.this, "Login Failed...!", Toast.LENGTH_LONG).show();
                                    clear();
                                }
                            }
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }



    public void clear(){
        username.setText("");
        password.setText("");
    }
    public class scan extends AsyncTask<String, String, String> {

        private ProgressDialog pd;

        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(LoginPage.this);
            pd.setTitle("Please Wait!!");
            pd.setMessage("Logging you In....");
            pd.setMax(10);
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            return null;
        }
    }
}
