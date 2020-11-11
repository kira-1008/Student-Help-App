package com.example.studentshelpapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity  extends AppCompatActivity {

    private ImageView logo;
    private static int splashTime=1000;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = (ImageView)findViewById(R.id.logo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    //User is Logged in
                    Intent i = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    //No User is Logged in
                    Intent i = new Intent(SplashActivity.this,login.class);
                    startActivity(i);
                    finish();
                }

            }
        },splashTime);

        Animation splash = AnimationUtils.loadAnimation( this , R.anim.splashanimation);
        logo.startAnimation(splash);
    }

}
