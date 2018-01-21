package com.projetodoertheia.a5cta;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.projetodoertheia.a5cta.NoticiasFirebase.NoticiasActivity;

public class SplashActivity extends AppCompatActivity implements Runnable {

    TextView txtBemvindo;
    ImageView imageView;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        YoYo.with(Techniques.DropOut).duration(700).playOn(findViewById(R.id.RelativoLayout));
        YoYo.with(Techniques.DropOut).duration(2000).playOn(findViewById(R.id.ImagemCTA));
        YoYo.with(Techniques.DropOut).duration(2700).playOn(findViewById(R.id.txt_BemVindo));

        imageView = (ImageView)findViewById(R.id.ImagemCTA);
        relativeLayout = (RelativeLayout)findViewById(R.id.RelativoLayout);

        txtBemvindo = (TextView)findViewById(R.id.txt_BemVindo);
        Typeface myTypeface = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/Roboto-Black.ttf");

        txtBemvindo.setTypeface(myTypeface);


        Handler handler = new Handler();
        handler.postDelayed(this, 2800);

//        DropOut).duration(2000 Nascendo
//        YoYo.with(Techniques.FadeOutRight).duration(2000) Apagando



    }

    public void run()
    {
        startActivity(new Intent(this, NoticiasActivity.class));
        finish();
    }

}
