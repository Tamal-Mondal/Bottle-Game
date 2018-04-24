package com.example.user_administrator.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button btn,b1,b2,b3,b4,b5,b6,b8,b9,b10,b11,b12,b13;
    EditText tn,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t2=(EditText)findViewById(R.id.t2);
        t3=(EditText)findViewById(R.id.t3);
        t4=(EditText)findViewById(R.id.t4);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b8=(Button)findViewById(R.id.b8);
        b9=(Button)findViewById(R.id.b9);
        b10=(Button)findViewById(R.id.b10);
        b11=(Button)findViewById(R.id.b11);
        b12=(Button)findViewById(R.id.b12);
        b13=(Button)findViewById(R.id.b13);



    //    t1=(TextView)findViewById(R.id.name);
       // tn=(EditText)findViewById(R.id.t1);
  //      btn=findViewById(R.id.btn);
    //    b1=(Button)findViewById(R.id.b1);
 /*       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               t1.setText("hello usa");
            }
        });
        Handler hd=new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setText("hello japan");
            }
        },3000);*/

      /*  b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer s1 = new StringBuffer(tn.getText());
                String s3=s1.toString();
                StringBuffer s2 =s1.reverse();
                if(s3.compareTo(s2.toString())==0)
                {
                  //    tn.setText(s3+" is a palindrome.");
                    Toast.makeText(MainActivity.this,"Palindrome",Toast.LENGTH_LONG).show();
                }
                else
                {
                 //   tn.setText(s3+" is a not palindrome.");
                    Toast.makeText(MainActivity.this,"Not Palindrome",Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }

    public void plus(View view)
    {
        int a = Integer.parseInt(t2.getText().toString());
        int b = Integer.parseInt(t3.getText().toString());
        int c = a+b;
        t4.setText(String.valueOf(c));
    }

    public void mine(View view)
    {
        int a = Integer.parseInt(t2.getText().toString());
        int b = Integer.parseInt(t3.getText().toString());
        int c = a-b;
        t4.setText(String.valueOf(c));
    }

   public void mul(View view)
    {
        int a = Integer.parseInt(t2.getText().toString());
        int b = Integer.parseInt(t3.getText().toString());
        int c = a*b;
        t4.setText(String.valueOf(c));
    }

   public void div(View view)
    {
        float a=Float.parseFloat(t2.getText().toString());
        float b=Float.parseFloat(t3.getText().toString());
        float c=a/b;
        t4.setText(String.valueOf(c));
    }

    public void newact(View view)
    {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void data(View view)
    {
        Intent intent = new Intent(this,database.class);
        startActivity(intent);
    }

    public void life(View view)
    {
        Intent intent = new Intent(this,lifecycle.class);
        startActivity(intent);
    }

    public void reg(View view)
    {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }

    public void game(View view)
    {
        Intent intent = new Intent(this,GameFirst.class);
        startActivity(intent);
    }

    public void blink(View view)
    {
        Intent intent = new Intent(this,Blink.class);
        startActivity(intent);
    }

    public void sense(View view)
    {
        Intent intent = new Intent(this,mysensor.class);
        startActivity(intent);
    }
}
