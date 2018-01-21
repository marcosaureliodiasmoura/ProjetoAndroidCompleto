package com.projetodoertheia.a5cta.NoticiasFirebase.mRecycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.projetodoertheia.a5cta.Firebase.m_Picasso.PicassoClient;
import com.projetodoertheia.a5cta.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import android.support.v7.palette.BuildConfig.*;
import android.support.v7.graphics.Palette;


public class DetailActivityNoticias extends AppCompatActivity {

    TextView titulo, subtitulo, detalhe;
    ImageView imagemurl;
    private Bitmap mImage;
    Context context;
    private static final String Imagem  = "IMAGE_KEY";


    private void loadPallete() {
        BitmapDrawable drawable = (BitmapDrawable) imagemurl.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        Palette.Builder builder = new Palette.Builder(bitmap);
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
           Palette.Swatch vibrant = palette.getVibrantSwatch();
                if(vibrant != null)
                {

                    titulo.setTextColor(vibrant.getBodyTextColor());
                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity_noticias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detalhesToolbar);
//        setSupportActionBar(toolbar);
        toolbar.setTitle("Exercito Brasileiro");
//        toolbar.setSubtitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        titulo = (TextView)findViewById(R.id.detalheTitulo);
        Typeface myTypeface = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/Roboto-Medium.ttf");

        titulo.setTypeface(myTypeface);
        subtitulo = (TextView)findViewById(R.id.detalheDescricao);
        Typeface myTypeface2 = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/Roboto-Light.ttf");

        subtitulo.setTypeface(myTypeface2);
        imagemurl = (ImageView)findViewById(R.id.detalheImagem);
//        detalhe = (TextView)findViewById(R.id.detalheteste);

//        YoYo.with(Techniques.Landing).duration(2000).
//        SlideInRight
        YoYo.with(Techniques.SlideInUp).duration(2000).playOn(findViewById(R.id.CordenaLayout));
        YoYo.with(Techniques.SlideInUp).duration(2200).playOn(findViewById(R.id.detalheImagem));


        Intent i = this.getIntent();

        String name = i.getExtras().getString("NAME_KEY");
        String desc = i.getExtras().getString("DESCR_KEY");
        String img  = i.getExtras().getString("IMAGE_KEY");
        int img2 = i.getExtras().getInt("IMAGE_KEY");
//        int img3 = i.getIntExtra("IMAGE_KEY",R.drawable.carregando);


        titulo.setText(name);
        subtitulo.setText(desc);
//        detalhe.setText(img);
        Picasso.with(this).load(img).into(imagemurl, new Callback() {
            @Override
            public void onSuccess() {
                loadPallete();
            }

            @Override
            public void onError() {

            }
        });
//        imagemurl.setImageResource(img2);







    }



}
