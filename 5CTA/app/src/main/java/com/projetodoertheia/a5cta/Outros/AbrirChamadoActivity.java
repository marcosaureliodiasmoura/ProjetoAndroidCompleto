package com.projetodoertheia.a5cta.Outros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.projetodoertheia.a5cta.R;

public class AbrirChamadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir_chamado);


        WebView wv = (WebView)findViewById(R.id.webView_AbrirChamado);

        WebSettings ws = wv.getSettings();

        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(true);

        wv.setWebViewClient(
                new wvClient()
        );


        wv.loadUrl("http://www.5cta.eb.mil.br/index.php/2013-10-27-00-11-10");


    }
}
