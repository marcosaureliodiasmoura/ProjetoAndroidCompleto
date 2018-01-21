package com.projetodoertheia.a5cta.Cursos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.projetodoertheia.a5cta.R;
import com.projetodoertheia.a5cta.Outros.wvClient;

public class MatriculaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula);



        WebView wv = (WebView)findViewById(R.id.webView_Matricula);

        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        wv.setWebViewClient(
                new wvClient()
        );

        wv.loadUrl("intranet.5cta.eb.mil.br");





//        wv.loadUrl("http://www.5cta.eb.mil.br/");




    }
}
