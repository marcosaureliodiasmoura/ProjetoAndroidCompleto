package com.projetodoertheia.a5cta.Cursos.Calendario;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.projetodoertheia.a5cta.R;

public class FormularioMatricula extends AppCompatActivity  {

    private Button botaoEnviar;
    private String email_enviar="marcos_moura@live.com";
    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_matricula);

        botaoEnviar  = (Button)findViewById(R.id.btn_enviar);



        nome = (EditText)findViewById(R.id.edt_Nome);


        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!nome.getText().toString().equals(""));
                enviarEmail();
            }
        });



    }

    private void enviarEmail() {

        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setData(Uri.parse("marcos_moura@live.com"));
        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email_enviar}.toString());
        intent.putExtra(Intent.EXTRA_SUBJECT,nome.getText().toString());

//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"marcos_moura@live.com"}.toString());

        try{
            startActivity(intent.createChooser(intent, "Email Enviado!"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
