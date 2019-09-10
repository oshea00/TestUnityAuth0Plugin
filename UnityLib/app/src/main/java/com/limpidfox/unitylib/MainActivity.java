package com.limpidfox.unitylib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.limpidfox.unityplugin.UnityAuth0Helper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UnityAuth0Helper.DoThisInAndroid("Called from Unity");

    }
}
