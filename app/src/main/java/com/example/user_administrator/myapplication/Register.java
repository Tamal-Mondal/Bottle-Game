package com.example.user_administrator.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{

    EditText name,user,phone,pass;
    Button clear,reg;
    Context con = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name =(EditText)findViewById(R.id.Rname);
        user =(EditText)findViewById(R.id.Ruser);
        phone =(EditText)findViewById(R.id.Rphone);
        pass =(EditText)findViewById(R.id.Rpass);
        clear = (Button)findViewById(R.id.resetR);
        reg = (Button)findViewById(R.id.register);

        clear.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.resetR: name.getText();name.setText("");
                user.getText();user.setText("");
                phone.getText();phone.setText("");
                pass.getText();pass.setText("");
                break;
            case R.id.register:
                DatabaseUser db = new DatabaseUser(con);
                if(db.register(name.getText().toString(),user.getText().toString(),phone.getText().toString(),pass.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Registration Success",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
                break;
        }
    }
}
