package com.projetodoertheia.a5cta.Firebase.m_Picasso;

import android.content.Context;
import android.widget.ImageView;

import com.projetodoertheia.a5cta.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by Marcos on 20/08/2016.
 */
public class PicassoClient {

    //verificar o placeholder
    public static void downloadImagem(Context c, String url, ImageView img, Callback callback)
    {
        if (url != null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.carregando).into(img);
        }
        else
        {
            Picasso.with(c).load(R.drawable.carregando).into(img);
        }
    }





}
