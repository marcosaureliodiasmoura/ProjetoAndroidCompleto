package com.projetodoertheia.a5cta.Cursos;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.projetodoertheia.a5cta.R;
import com.projetodoertheia.a5cta.Outros.wvClient;

/**
 * A simple {@link Fragment} subclass.
 */
public class EadFragment extends android.support.v4.app.Fragment {


    public EadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            // Inflate the layout for this fragment
            View rootview = inflater.inflate(R.layout.fragment_ead, container, false);

            if(container == null)
            {
                return null;
            }


            WebView webView = (WebView)rootview.findViewById(R.id.wv_EAD_Fragment);
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

            webView.loadUrl("https://ead.5cta.eb.mil.br/login/index.php");

//        video.setVideoURI(src);
//
//        video.setMediaController(new MediaController(this.getActivity()));
//
            return rootview;
        }

}
