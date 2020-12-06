package com.example.myparkingtask.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.myparkingtask.home.MainActivity;
import com.example.myparkingtask.R;
import com.example.myparkingtask.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    Animation a;
    ActivitySplashBinding activitySplashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySplashBinding=ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(activitySplashBinding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        a = AnimationUtils.loadAnimation(this, R.anim.animation);
        activitySplashBinding.text.startAnimation(a);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this,
                    MainActivity.class );
            startActivity(intent);
            finish();
        }, 2000);
    }
}