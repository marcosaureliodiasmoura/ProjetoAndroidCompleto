package com.projetodoertheia.a5cta.RssNoticias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.projetodoertheia.a5cta.R;

public class DetailsNoticias extends AppCompatActivity {

    WebView webViewNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_noticias);

        webViewNoticias = (WebView)findViewById(R.id.webView_noticias);
        Bundle bundle=getIntent().getExtras();
        webViewNoticias.loadUrl(bundle.getString("Link"));






    }
}
