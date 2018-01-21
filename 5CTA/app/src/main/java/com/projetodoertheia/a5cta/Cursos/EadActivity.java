package com.projetodoertheia.a5cta.Cursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.projetodoertheia.a5cta.R;
import com.projetodoertheia.a5cta.Outros.wvClient;

public class EadActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ead);



        WebView wv = (WebView)findViewById(R.id.webView_EAD);

        WebSettings ws = wv.getSettings();

        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(true);

        wv.setWebViewClient(
                new wvClient()
        );


        wv.loadUrl("https://ead.5cta.eb.mil.br/login/index.php");


//        Utilizando javascript

//        wv.loadUrl("https://ead.5cta.eb.mil.br/login/index.php");
//
//        String html = "<html>";
//        html += "<body>";
//        html += "<img src=\"http://www.5cta.eb.mil.br/templates/padraogoverno01/images/logo-om.png\"  " +
//                "style=\"float: left; display: block; margin-right: 10px;\" />";
//
//        html += "<h3 id=\"h3\" style=\"float: left;\">Texto auxiliar</h3>";
//        html += "<script type=\"text/javascript\">";
//        html += "document.getElementById('h3').style.color = '#ff0000';";
//        html += "</script></body></html>";
//
//        wv.loadData(html, "text/html", "UTF-8");


    }
}
