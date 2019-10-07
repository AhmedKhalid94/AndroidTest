package com.ahmed94.friends;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private TextView madLogo, houseLogo;
    private TextView kidsLearning, from;
    private ImageView image1, image2, image3;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fullscreen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        controlTrialVersiono();

        madLogo = (TextView) findViewById(R.id.mad_logo);
        houseLogo = (TextView) findViewById(R.id.house_logo);
        kidsLearning = (TextView) findViewById(R.id.text_kids_learning);
        from = (TextView) findViewById(R.id.text_from_splash);
        image1 = (ImageView) findViewById(R.id.splash_image1);
        image2 = (ImageView) findViewById(R.id.splash_image2);
        image3 = (ImageView) findViewById(R.id.splash_image3);
        parent = (ConstraintLayout) findViewById(R.id.parent_splash);

        Typeface  edo = Typeface.createFromAsset(getAssets(), "fonts/jokerman_regular.ttf");
        kidsLearning.setTypeface( edo);
        from.setTypeface( edo);

        Typeface c = Typeface.createFromAsset(getAssets(), "fonts/jokerman_regular.ttf");
        madLogo.setTypeface(c);
        Typeface b = Typeface.createFromAsset(getAssets(), "fonts/jokerman_regular.ttf");
        houseLogo.setTypeface(b);

        Animation zoom0 = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        Animation zoom1 = AnimationUtils.loadAnimation(this, R.anim.zoom1);
        Animation zoom2 = AnimationUtils.loadAnimation(this, R.anim.zoom2);
        Animation zoom3 = AnimationUtils.loadAnimation(this, R.anim.zoom3);
        Animation zoom4 = AnimationUtils.loadAnimation(this, R.anim.zoom4);
        Animation zoom5 = AnimationUtils.loadAnimation(this, R.anim.zoom5);

        zoom0.reset();
        kidsLearning.clearAnimation();
        kidsLearning.startAnimation(zoom0);

        zoom1.reset();
        image1.clearAnimation();
        image1.startAnimation(zoom1);

        zoom2.reset();
        image2.clearAnimation();
        image2.startAnimation(zoom2);

        zoom3.reset();
        image3.clearAnimation();
        image3.startAnimation(zoom3);

        zoom4.reset();
        from.clearAnimation();
        from.startAnimation(zoom4);

        zoom5.reset();
        madLogo.clearAnimation();
        houseLogo.clearAnimation();
        madLogo.startAnimation(zoom5);
        houseLogo.startAnimation(zoom5);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3500);
    }

    private void controlTrialVersiono() {
        TrialSharedPreferences trialSharedPreferences = new TrialSharedPreferences(this);
        trialSharedPreferences.controlTrial(new TrialCallback() {
            @Override
            public void onActive() {

            }

            @Override
            public void onTrialEnd() {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(SplashActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(SplashActivity.this);
                }
                builder.setTitle("انتهت النسخة التجريبية")
                        .setMessage("شكرا لاسختدامك التطبيق.. انتهت المدة التجريبية")
                        .setPositiveButton("إغلاق", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                                finish();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });
    }
}
