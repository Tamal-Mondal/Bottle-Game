package com.example.user_administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class lifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d("MESSAGE", "onCreate() Invoked");
        Toast.makeText(this,"onCreate() Invoked",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d("MESSAGE", "onStart() Invoked");
        Toast.makeText(this,"onStart() Invoked",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d("MESSAGE", "onResume() Invoked");
        Toast.makeText(this,"onResume() Invoked",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d("MESSAGE", "onPause() Invoked");
        Toast.makeText(this,"onPause() Invoked",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d("MESSAGE", "onStop() Invoked");
        Toast.makeText(this,"onStop() Invoked",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d("MESSAGE", "onDestroy() Invoked");
        Toast.makeText(this,"onDestroy() Invoked",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.d("MESSAGE", "onRestart() Invoked");
        Toast.makeText(this,"onRestart() Invoked",Toast.LENGTH_LONG).show();
    }
}
