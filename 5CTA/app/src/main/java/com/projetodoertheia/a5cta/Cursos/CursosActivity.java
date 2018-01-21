package com.projetodoertheia.a5cta.Cursos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.projetodoertheia.a5cta.Cursos.VideoAulas.Aula1Activity;
import com.projetodoertheia.a5cta.R;

import static com.google.android.gms.analytics.internal.zzy.v;

/**
 * Created by Ertheia on 23/09/2017.
 */

public class CursosActivity extends AppCompatActivity implements View.OnClickListener {

    Button botao_Calendario;
    Button botao_EAD;
    Button botao_Matricula;
    Button btn17, btn18, btn19, btn20, btn21, btn22, btn23;


    private final VideosFragment videosFragment = new VideosFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cursos);


        botao_Calendario = (Button) findViewById(R.id.btn_calendario);
        botao_Calendario.setOnClickListener(this);


        botao_EAD = (Button) findViewById(R.id.btn_ead);
        botao_EAD.setOnClickListener(this);


        botao_Matricula = (Button) findViewById(R.id.btn_matricula);
        botao_Matricula.setOnClickListener(this);


        btn17 = (Button) findViewById(R.id.button17);
        btn17.setOnClickListener(this);

        btn18 = (Button) findViewById(R.id.button18);
        btn18.setOnClickListener(this);

        btn19 = (Button) findViewById(R.id.button19);
        btn19.setOnClickListener(this);

        btn20 = (Button) findViewById(R.id.button20);
        btn20.setOnClickListener(this);

        btn21 = (Button) findViewById(R.id.button21);
        btn21.setOnClickListener(this);

        btn22 = (Button) findViewById(R.id.button22);
        btn22.setOnClickListener(this);

        btn23 = (Button) findViewById(R.id.button23);
        btn23.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
//
//        Intent it1 = new Intent(this, com.projetodoertheia.a5cta.Cursos.MatriculaActivity.class );
//        startActivity(it1);

        switch (v.getId ()) {
            case R.id.btn_calendario:

                Intent it1 = new Intent(this, com.projetodoertheia.a5cta.Cursos.Calendario.CalendarioActivity.class);
                startActivity(it1);
                break;


            case R.id.btn_ead:

                Intent it2 = new Intent(this, EadActivity.class);
                startActivity(it2);
                break;

            case R.id.btn_matricula:
                Intent it3 = new Intent(this, OpenMatriculaActivity.class);
                startActivity(it3);
                break;


            case R.id.button17:
                Intent it4 = new Intent(this, Aula1Activity.class);
                startActivity(it4);
                break;


        }

    }
}
