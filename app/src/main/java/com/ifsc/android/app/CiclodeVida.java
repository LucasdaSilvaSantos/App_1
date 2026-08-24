package com.ifsc.android.app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class CiclodeVida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
        Log.d("CiclodeVida","oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_LONG).show();
        Log.d("CiclodeVida","onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_LONG).show();
        Log.d("CiclodeVida","onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_LONG).show();
        Log.d("CiclodeVida","onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_LONG).show();
        Log.d("CiclodeVida","onstop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestar",Toast.LENGTH_LONG).show();
        Log.d("CiclodeVida","onrestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_LONG).show();
        Log.d("CiclodeVida","ondestroy");
    }
}