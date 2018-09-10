package com.example.wictor.clickk;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView clicks, amount1, amount2, amount3, amount4;
    ImageButton button, sound, mute, item1, item2, item3, item4;
    int timesClicked, amountNumber1, amountNumber2, amountNumber3, amountNumber4;
    MediaPlayer bgmusic, clickSound, denySound;
    ConstraintLayout box1;
    boolean isPaused=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgmusic = MediaPlayer.create(MainActivity.this,R.raw.alpacasoundtrack);
        bgmusic.start();
        bgmusic.setLooping(true);
        denySound = MediaPlayer.create(MainActivity.this, R.raw.claus);
        clickSound = MediaPlayer.create(MainActivity.this, R.raw.horge);

        //Initiate items by id
        clicks = (TextView) findViewById(R.id.clicks);
        amount1 = (TextView) findViewById(R.id.amountText1);
        amount2 = (TextView) findViewById(R.id.amountText2);
        amount3 = (TextView) findViewById(R.id.amountText3);
        amount4 = (TextView) findViewById(R.id.amountText4);
        button = (ImageButton) findViewById(R.id.imgbutton);
        sound = (ImageButton) findViewById(R.id.sound);
        mute = (ImageButton) findViewById(R.id.mute);
        item1 = (ImageButton) findViewById(R.id.imageButton);
        item2 = (ImageButton) findViewById(R.id.bonde);
        item3 = (ImageButton) findViewById(R.id.imageButton3);
        item4 = (ImageButton) findViewById(R.id.imageButton4);

        //enable button
        button.setEnabled(true);
        didTapButton();
        load();
    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    public void load(){
        SharedPreferences preferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        timesClicked = preferences.getInt("timesClicked", 0);
        clicks.setText("" + timesClicked);
        amountNumber1 = preferences.getInt("amount1", 0);
        amount1.setText(""+amountNumber1);
        amountNumber2 = preferences.getInt("amount2", 0);
        amount2.setText(""+amountNumber2);
        amountNumber3 = preferences.getInt("amount3", 0);
        amount3.setText(""+amountNumber3);
        amountNumber4 = preferences.getInt("amount4", 0);
        amount4.setText(""+amountNumber4);
        clicks.setTypeface(null, Typeface.BOLD);
    }

    public void save() {
        SharedPreferences preferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("timesClicked", timesClicked);
        editor.putInt("amount1", amountNumber1);
        editor.putInt("amount2", amountNumber2);
        editor.putInt("amount3", amountNumber3);
        editor.putInt("amount4", amountNumber4);
        editor.commit();
    }

    public void didTapButton() {
        // Load the animation
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        double animationDuration = 2000;
        myAnim.setDuration((long)animationDuration);
        // Use custom animation interpolator to achieve the bounce effect
        MyBounce interpolator = new MyBounce(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPaused){
                    clickSound.start();
                }
                timesClicked++;
                clicks.setText("" + timesClicked);
                button.startAnimation(myAnim);
                save();
            }
        });

        //Practically the mute button
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setVisibility(View.INVISIBLE);
                mute.setVisibility(View.VISIBLE);
                mute();
            }
        });
        //play sound
        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.setVisibility(View.VISIBLE);
                mute.setVisibility(View.INVISIBLE);
                resume();
            }
        });

        // Click boxes
        //ITEM 1
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timesClicked < 100){
                    if (isPaused){
                        denySound.start();
                    }
                }
                if (timesClicked >= 100){
                    if(isPaused){
                        clickSound.start();
                    }
                    timesClicked -= 100;
                    clicks.setText("" + timesClicked);
                    amountNumber1++;
                    amount1.setText(""+amountNumber1);
                }
            }
        });
        // ITEM 2
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timesClicked < 500){
                    if (isPaused){
                        denySound.start();
                    }
                }
                if (timesClicked >= 500){
                    if(isPaused){
                        clickSound.start();
                    }
                    timesClicked -= 500;
                    clicks.setText("" + timesClicked);
                    amountNumber2++;
                    amount2.setText(""+amountNumber2);
                }
            }
        });
        //ITEM 3
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timesClicked < 1000){
                    if (isPaused){
                        denySound.start();
                    }
                }
                if (timesClicked >= 1000){
                    if(isPaused){
                        clickSound.start();
                    }
                    timesClicked -= 1000;
                    clicks.setText("" + timesClicked);
                    amountNumber3++;
                    amount3.setText(""+amountNumber3);
                }
            }
        });
        //ITEM 4
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timesClicked < 5000){
                    if (isPaused){
                        denySound.start();
                    }
                }
                if (timesClicked >= 5000){
                    if(isPaused){
                        clickSound.start();
                    }
                    timesClicked -= 5000;
                    clicks.setText("" + timesClicked);
                    amountNumber4++;
                    amount4.setText(""+amountNumber4);
                }
            }
        });


    }

    public void mute(){
        bgmusic.pause();
        clickSound.pause();
        denySound.pause();
        isPaused = false;
    }

    public void resume(){
        bgmusic.start();
        isPaused =true;
    }

    @Override
    public void onPause(){
        super.onPause();
        bgmusic.release();
        finish();

    }
}
