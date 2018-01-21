package com.projetodoertheia.a5cta.Cursos.VideoAulas;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.projetodoertheia.a5cta.R;

import static android.R.attr.id;

public class Aula1Activity extends AppCompatActivity {

    ProgressBar Progress01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula1);
//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarAulas);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });




        VideoView video = (VideoView)findViewById(R.id.videoView2);

        Uri src = Uri.parse("https://firebasestorage.googleapis.com/v0/b/cta-4f03b.appspot.com/o/Videos%20CTA%2FTop%205%20Material%20Design%20Apps%20(2015).mp4?alt=media&token=1f5ae8ed-71d7-401a-9b0f-a36dc74dfda6");


        video.setVideoURI(src);

        video.setMediaController(new MediaController(this));






    }

}
