package com.example.user_administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

public class Main2Activity extends AppCompatActivity {

    EditText et1,et2,et3,et4,et5;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
        bt1=(Button) findViewById(R.id.bt1);


        Toast.makeText(this, "Fill Up The Registration Form", Toast.LENGTH_LONG).show();
    }

    public void submit(View view)
    {
        String t1 = et1.getText().toString();
        String t2 = et2.getText().toString();
        String t3 = et3.getText().toString();
        String t4 = et4.getText().toString();
        String roll = et5.getText().toString();
        String searchTerm = t1+"\n"+t2+"\n"+t3+"\n"+t4+"\n"+roll+"\n";

        Intent i = new Intent(this,success.class);

        //Create the bundle
        Bundle bundle = new Bundle();
        //Add your data from getFactualResults method to bundle
        bundle.putString("VENUE_NAME", searchTerm);
        //Add the bundle to the intent
        i.putExtras(bundle);

        startActivity(i);
    }
}
