package com.example.sewa_lapangan.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sewa_lapangan.Login.SignInActivity;
import com.example.sewa_lapangan.R;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        im = (ImageView) findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animasi);
        im.startAnimation(animation);

        final Intent i = new Intent(this, SignInActivity.class);
        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        thread.start();
    }
}