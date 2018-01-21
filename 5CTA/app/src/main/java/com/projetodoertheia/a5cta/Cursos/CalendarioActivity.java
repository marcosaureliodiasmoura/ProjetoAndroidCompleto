package com.projetodoertheia.a5cta.Cursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.projetodoertheia.a5cta.R;

public class CalendarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calendario);

        WebView webView = new WebView(CalendarioActivity.this);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new Callback());

        webView.loadUrl("https://drive.google.com/file/d/0B1NO1vWNmqijWExEN0czZElOams/view?usp=sharing");

        setContentView(webView);




    }

    private class Callback extends WebViewClient{


        public boolean shouldOverriderUrlLoading(
                WebView view, String url){
            return (false);
        }

    }
}
