package com.example.user_administrator.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class database extends AppCompatActivity implements AdapterView.OnItemClickListener{

    EditText ed1,ed2;
    Spinner sp1;
    AutoCompleteTextView act1;
    RatingBar rb1;
    Button bt1;

    String[] college = {"NSEC", "MSIT", "TISL", "FIEM", "IEM", "HIT"};
    String[] stream = {"CSE", "IT", "ECE", "ME", "CE", "EE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        sp1=findViewById(R.id.sp1);
        act1=findViewById(R.id.act1);
        rb1=findViewById(R.id.rb1);
        bt1=findViewById(R.id.bt1);

       // sp1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,stream);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(aa);


        ArrayAdapter<String> adopter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, college);
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.act1);
        actv.setThreshold(1);
        actv.setAdapter(adopter);
        actv.setTextColor(Color.RED);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Toast.makeText(this,stream[i],Toast.LENGTH_LONG).show();
    }

    public void submit(View view)
    {
        float rate = rb1.getRating();
        String s = String.valueOf(rate);

        String ans = "First Name:"+ed1.getText().toString()+"\n"+"Last Name:"+ed2.getText().toString()+"\n"+"College:"+act1.getText().toString()+"\n"+"Stream :"+sp1.getSelectedItem().toString()+"\n"+"Rating: "+s+"\n";
        Toast.makeText(this, ans, Toast.LENGTH_LONG).show();
    }
}
