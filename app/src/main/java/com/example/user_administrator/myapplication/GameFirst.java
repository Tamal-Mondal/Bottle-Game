package com.example.user_administrator.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameFirst extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2,et3,et4;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_first);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        bt1 = findViewById(R.id.button1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c=1;
                Intent i = new Intent(GameFirst.this,GameNew.class);
                for(int j=1;j<=4;j++)
                {
                    if(j==1)
                    {
                        if(et1.getText().toString().length()>0)
                        {
                            i.putExtra("P1",et1.getText().toString());
                        }
                        else
                        {
                            i.putExtra("P1","CPU"+c);
                            c++;
                        }
                    }
                    else if(j==2)
                    {
                        if(et2.getText().toString().length()>0)
                        {
                            i.putExtra("P2",et2.getText().toString());
                        }
                        else
                        {
                            i.putExtra("P2","CPU"+c);
                            c++;
                        }
                    }
                    else if(j==3)
                    {
                        if(et3.getText().toString().length()>0)
                        {
                            i.putExtra("P3",et3.getText().toString());
                        }
                        else
                        {
                            i.putExtra("P3","CPU"+c);
                            c++;
                        }
                    }
                    else
                    {
                        if(et4.getText().toString().length()>0)
                        {
                            i.putExtra("P4",et4.getText().toString());
                        }
                        else
                        {
                            i.putExtra("P4","CPU"+c);
                            c++;
                        }
                    }
                }
                startActivity(i);
                finish();
            }
        });
    }

 /*   public void go(View v)
    {
        int c=1;
        Intent i = new Intent(GameFirst.this,GameNew.class);
        for(int j=1;j<=4;j++)
        {
            if(j==1)
            {
                if(et1.getText().toString().length()>0)
                {
                    i.putExtra("P1",et1.getText().toString());
                }
                else
                {
                    i.putExtra("P1","CPU"+c);
                    c++;
                }
            }
            else if(j==2)
            {
                if(et2.getText().toString().length()>0)
                {
                    i.putExtra("P2",et2.getText().toString());
                }
                else
                {
                    i.putExtra("P2","CPU"+c);
                    c++;
                }
            }
            else if(j==3)
            {
                if(et3.getText().toString().length()>0)
                {
                    i.putExtra("P3",et3.getText().toString());
                }
                else
                {
                    i.putExtra("P3","CPU"+c);
                    c++;
                }
            }
            else
            {
                if(et4.getText().toString().length()>0)
                {
                    i.putExtra("P4",et4.getText().toString());
                }
                else
                {
                    i.putExtra("P4","CPU"+c);
                    c++;
                }
            }
        }
        startActivity(i);
        finish();
    }*/

    @Override
    public void onClick(View view) {

    }
}
