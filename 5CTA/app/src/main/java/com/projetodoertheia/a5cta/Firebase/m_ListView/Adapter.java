package com.projetodoertheia.a5cta.Firebase.m_ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.projetodoertheia.a5cta.Firebase.m_Data.Noticias;
import com.projetodoertheia.a5cta.Firebase.m_Picasso.PicassoClient;
import com.projetodoertheia.a5cta.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Marcos on 20/08/2016.
 */
public class Adapter extends BaseAdapter {

    Context c;
    ArrayList<Noticias>noticias;
    LayoutInflater inflater;


    public Adapter(Context c, ArrayList<Noticias> noticias) {
        this.c = c;
        this.noticias = noticias;
    }

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int position) {
        return noticias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater==null)
        {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_main_noticias_modelo,parent,false);
        }


        MyViewHolder holder = new MyViewHolder(convertView);

        holder.titulotexto.setText(noticias.get(position).getTitulo());
        //colocar os demais aqui
        PicassoClient.downloadImagem(c,noticias.get(position).getImagemurl(),holder.img, new Callback() {
//            Picasso.with(this.c).load(n.getImagemurl()).into(Recycler_Imagem, new Callback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError() {
            }
        });
        holder.subtitulotexto.setText(noticias.get(position).getSubtitulo());

        return convertView;
    }
}
