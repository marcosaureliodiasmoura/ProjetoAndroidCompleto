package com.projetodoertheia.a5cta.Firebase.m_ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.projetodoertheia.a5cta.R;

/**
 * Created by Marcos on 20/08/2016.
 */
public class MyViewHolder {

    TextView titulotexto;
    ImageView img;
    TextView subtitulotexto;
    TextView descricaoTexto;

    public MyViewHolder(View itemView)
    {
        titulotexto = (TextView)itemView.findViewById(R.id.txt_titulo_noticias);
        subtitulotexto = (TextView)itemView.findViewById(R.id.txt_descr_noticias);
        descricaoTexto = (TextView)itemView.findViewById(R.id.txt_descr2_noticias);
        img = (ImageView)itemView.findViewById(R.id.thumbnaill_noticias);




    }





}
