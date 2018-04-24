package com.example.user_administrator.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameNew extends AppCompatActivity {
    int lastAngle = -1;
    Random rand = new Random();
    View root;
    ImageView bot;
    TextView tv1,tv2,tv3,tv4;

    String P1;
    String P2;
    String P3;
    String P4;

    Intent song;
    Intent val;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_new);
        root = findViewById(R.id.root);
        bot=findViewById(R.id.bottle);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

       val = getIntent();

       P1 = val.getStringExtra("P1");
       P2 = val.getStringExtra("P2");
       P3 = val.getStringExtra("P3");
       P4 = val.getStringExtra("P4");


        tv1.setText(P1);
        tv2.setText(P2);
        tv3.setText(P3);
        tv4.setText(P4);

        song = new Intent(this,MyService.class);
        startService(song);

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinTheBottle();
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
        stopService(song);
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        startService(song);
    }

    @Override
    public void onBackPressed()
    {   count++;
        if (count>1)
        {
            finish();
        }
        else
            Toast.makeText(this,"Double Back Press To Exit",Toast.LENGTH_LONG).show();

        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                count=0;
            }
        },1000);

       /* AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setMessage("Do You Want To Exit?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
        .setCancelable(true);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                AlertDialog.Builder build = new AlertDialog.Builder(this);
                build.setMessage("An game developed by Us.");
                build.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                build.setPositiveButton("Visit Website", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String url = "http://www.facebook.com";
                        Intent ni = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(ni);
                    }
                });
                build.setCancelable(false);

                AlertDialog alert = build.create();
                alert.setTitle("About Us");
                alert.show();
                break;
            case R.id.reset:
                if(root.isClickable())
                {
                    ResetTheBottle();
                }
                else
                {
                    Toast.makeText(this,"Dhiraj Rakho",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.exit:
                finish();
            case R.id.stop:
                stopService(song);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void spinTheBottle()
    {
       root.setClickable(false);
       int angle = rand.nextInt(3600-360)+360;
       int pivotX = bot.getWidth()/2;
       int pivotY = bot.getHeight()/2;
       Animation rotate = new RotateAnimation(lastAngle==-1 ? 0 : lastAngle,angle,pivotX,pivotY);
       rotate.setDuration(3000);
       rotate.setFillAfter(true);
       bot.startAnimation(rotate);
       lastAngle=angle;

        final int result = angle % 360;
        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (result > 0 && result <= 90) {
                    Toast.makeText(GameNew.this, P2+"'s Turn", Toast.LENGTH_SHORT).show();
                } else if (result > 90 && result <= 180) {
                    Toast.makeText(GameNew.this, P3+"'s Turn", Toast.LENGTH_SHORT).show();
                } else if (result > 180 && result <= 270) {
                    Toast.makeText(GameNew.this, P4+"'s Turn", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GameNew.this, P1+"'s Turn", Toast.LENGTH_SHORT).show();
                }
                root.setClickable(true);
            }
        }, 3000);

    }

    public void ResetTheBottle()
    {
        int angle = 0;
        int pivotX = bot.getWidth()/2;
        int pivotY = bot.getHeight()/2;
        Animation rotate = new RotateAnimation(lastAngle==-1 ? 0 : lastAngle,angle,pivotX,pivotY);
        rotate.setDuration(100);
        rotate.setFillAfter(true);
        bot.startAnimation(rotate);
        lastAngle=angle;
    }
}
