package com.projetodoertheia.a5cta.Outros;


import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.projetodoertheia.a5cta.R;


public class UniformesFragment extends android.support.v4.app.Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_uniformes, container, false);

        if(container == null)
        {
            return null;
        }


        WebView webView = (WebView)rootview.findViewById(R.id.webViewUniformes);
//
//        Uri src = Uri.parse("https://firebasestorage.googleapis.com/v0/b/cta-4f03b.appspot.com/o/Videos%20CTA%2FVIDEOS%20INSTITUCIONAL%20do%205%C2%BA%20CTA.mp4?alt=media&token=c700a81e-84fa-45ba-8784-9280f7e9c650");
////        android-app://com.google.android.youtube/http/www.youtube.com/watch?v=WfqDSnCkaro
////        http://www.youtube.com/oembed?url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DWfqDSnCkaro&amp;format=json
////        http://www.youtube.com/oembed?url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3DWfqDSnCkaro&amp;format=xml
//
//
        WebSettings ws = webView.getSettings();

        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(true);

        webView.setWebViewClient(
                new wvClient()
        );

        webView.loadUrl("http://feeds.feedburner.com/Rss-CinciaETecnologia");

//        video.setVideoURI(src);
//
//        video.setMediaController(new MediaController(this.getActivity()));
//
        return rootview;
    }


}
