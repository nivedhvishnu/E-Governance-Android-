package com.example.nived.e_governance;

/**
 * Created by nived on 24-05-2018.
 */

import android.app.Application;

public class Data extends Application{
    public String UserName;
    public String Password;


    public String GetUsername()
    {
        return UserName;
    }

    public void Setusername(String _susername)
    {
        UserName=_susername;

    }

    public String GetPassword()
    {
        return Password;
    }

    public void Setpassword(String _spassword)
    {
        Password=_spassword;

    }


}