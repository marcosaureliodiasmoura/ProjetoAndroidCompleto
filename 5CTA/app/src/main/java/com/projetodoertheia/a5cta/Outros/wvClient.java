package com.projetodoertheia.a5cta.Outros;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Marcos on 22/07/2016.
 */
public class wvClient extends WebViewClient{


    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed();
        // Ignore SSL certificate errors
    }

}
