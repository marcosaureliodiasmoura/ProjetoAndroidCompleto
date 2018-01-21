package com.projetodoertheia.a5cta.NoticiasFirebase.mRecycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.projetodoertheia.a5cta.R;

/**
 * Created by Marcos on 22/08/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView tituloTxt, subtituloTxt;
    ImageView img;
    ItemClickListener itemClickListener;
    CardView cardView;


    public MyHolder(View itemView) {
        super(itemView);

        img = (ImageView)itemView.findViewById(R.id.Recycler_Imagem);
        tituloTxt = (TextView)itemView.findViewById(R.id.Recycler_Titulo);
         subtituloTxt = (TextView)itemView.findViewById(R.id.Recycler_Subtitulo);
        cardView = (CardView)itemView.findViewById(R.id.Recycler_CardView);
//        relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativeLayoutTitulos);


        itemView.setOnClickListener(this);




    }



    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }


    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
}
