package com.projetodoertheia.a5cta.RssNoticias;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.projetodoertheia.a5cta.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Marcos on 13/08/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    ArrayList<FeedItem>feedItems;
    Context context;
    public MyAdapter(Context context, ArrayList<FeedItem>feedItems)
    {
        this.feedItems=feedItems;
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main_noticias_modelo, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //Animacao do github para o cardview https://github.com/daimajia/AndroidViewAnimations
        YoYo.with(Techniques.FadeIn).playOn(holder.cardView);

        final FeedItem current = feedItems.get(position);
        holder.Titulo.setText(current.getTitle());
        holder.Descricao.setText(current.getDescription());
        holder.Data.setText(current.getPubDate());
        Picasso.with(context).load(current.getThumbnailUrl()).into(holder.Thumbnail);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsNoticias.class);
                intent.putExtra("Link", current.getLink());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Titulo,Descricao,Data;
        ImageView Thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            Titulo= (TextView) itemView.findViewById(R.id.txt_titulo_noticias);
            Descricao = (TextView)itemView.findViewById(R.id.txt_descr_noticias);
//            Data = (TextView)itemView.findViewById(R.id.txt_data_noticias);
            Thumbnail = (ImageView)itemView.findViewById(R.id.thumbnaill_noticias);
            cardView= (CardView) itemView.findViewById(R.id.cardviewNoticias);
        }
    }
}
