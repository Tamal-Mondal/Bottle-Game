package com.example.user_administrator.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {

    EditText user,pass;
    Button clear,log,reg;
    Context con = this;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.userid);
        pass = (EditText)findViewById(R.id.password);
        clear = (Button)findViewById(R.id.reset);
        log = (Button)findViewById(R.id.login);
        reg = (Button)findViewById(R.id.register);

        log.setOnClickListener(this);
        reg.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    public boolean checkVal(){
        if(user.getText().toString().trim().length()>0 && pass.getText().toString().trim().length()>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.reset:
                user.getText();user.setText("");
                pass.getText();pass.setText("");
                break;
            case R.id.login:
                DatabaseUser db = new DatabaseUser(con);
                if(checkVal()) {
                    if (db.checkLogin(user.getText().toString(), pass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    pass.requestFocus();
                    pass.setError("Enter Both Values");
                }
                break;
            case R.id.register:
                Intent i = new Intent(login.this,Register.class);
                startActivity(i);
                finish();
                break;

        }
    }
}
