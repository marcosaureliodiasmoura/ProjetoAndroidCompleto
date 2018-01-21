package com.projetodoertheia.a5cta.Notificacoes.mPicasso;

import android.content.Context;
import android.widget.ImageView;

import com.projetodoertheia.a5cta.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Ertheia on 03/11/2017.
 */

public class PicassoClient {

    public static void downloadImage (Context c , String url, ImageView img)
    {
        if (url!=null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.carregando).into(img);

        }
        else {
            Picasso.with(c).load(R.drawable.carregando).into(img);
        }
    }
}
