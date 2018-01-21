package com.projetodoertheia.a5cta.Cursos;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.projetodoertheia.a5cta.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class OpenMatriculaActivity extends AppCompatActivity implements View.OnClickListener {


    TextView atencao, acessoRestrito, texto1, texto2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_matricula);


        Button btnContinuar = (Button)findViewById(R.id.btn_Continuar_Matricula);
        btnContinuar.setOnClickListener(this);

        atencao  = (TextView)findViewById(R.id.txtAtencaoo);
        Typeface myTypeface = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/Roboto-Black.ttf");

        atencao.setTypeface(myTypeface);

        acessoRestrito  = (TextView)findViewById(R.id.txt0AcessoRestrito);
        Typeface myTypeface2 = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/Roboto-Black.ttf");

        acessoRestrito.setTypeface(myTypeface2);


        texto1 = (TextView)findViewById(R.id.txt0texto);
        Typeface myTypeface3 = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/Roboto-Black.ttf");

        texto1.setTypeface(myTypeface3);

        texto2  = (TextView)findViewById(R.id.txt0texto2);
        Typeface myTypeface4 = Typeface.createFromAsset(
                this.getAssets(),
                "fonts/Roboto-Black.ttf");

        texto2.setTypeface(myTypeface3);



    }

    @Override
    public void onClick(View v) {
                finish();
                Intent it1 = new Intent(this, com.projetodoertheia.a5cta.Cursos.MatriculaActivity.class );
                startActivity(it1);


    }
}
