package com.projetodoertheia.a5cta.NoticiasFirebase.mRecycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.projetodoertheia.a5cta.Firebase.m_Picasso.PicassoClient;
import com.projetodoertheia.a5cta.NoticiasFirebase.mData.Noticias;
import com.projetodoertheia.a5cta.R;
import com.projetodoertheia.a5cta.RssNoticias.DetailsNoticias;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Marcos on 22/08/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Noticias> noticias;



    public MyAdapter(Context c, ArrayList<Noticias> noticias) {
        this.c = c;
        this.noticias = noticias;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelrecycler,parent, false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
//        FadeInDown
        YoYo.with(Techniques.FadeInDown).duration(2500).playOn(holder.cardView);
        final Noticias n = noticias.get(position);
        holder.tituloTxt.setText(noticias.get(position).getTitulo());
        holder.subtituloTxt.setText(noticias.get(position).getSubtitulo());





//        PicassoClient.downloadImagem(c,noticias.get(position).getImagemurl(),holder.img, new Callback() {
//            Picasso.with(this.c).load(n.getImagemurl()).into(holder.img, new Callback() {
        Picasso.with(this.c).load(n.getImagemurl()).into(holder.img);

//                Picasso.with(this).load(img).into(imagemurl, new Callback() {
////                @Override
////                public void onSuccess() {
////
////
////                    BitmapDrawable drawable = (BitmapDrawable) holder.img.getDrawable();
////                    Bitmap bitmap = drawable.getBitmap();
////
////                    Palette.Builder builder = new Palette.Builder(bitmap);
////                    builder.generate(new Palette.PaletteAsyncListener() {
////                        @Override
////                        public void onGenerated(Palette palette) {
////                            Palette.Swatch vibrant = palette.getVibrantSwatch();
////                            if(vibrant != null)
////                            {
////                                holder.relativeLayout.setBackgroundColor(vibrant.getRgb());
////                                holder.tituloTxt.setTextColor(vibrant.getBodyTextColor());
////
////
////
////                            }
////                        }
////                    });
////
////                }
//
//                @Override
//                public void onError() {
//
//                }
//            });


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                //Abrir o detail

                openDetailActivity(n.getTitulo(),n.getSubtitulo(),n.getImagemurl());
            }
        });

    }

    private void loadPallete(View v) {



    }

    @Override
    public int getItemCount() {

        return noticias.size();

    }


    //abrir detail
    private void openDetailActivity(String...details)
    {
        Intent i =new Intent(c, DetailActivityNoticias.class);


        i.putExtra("NAME_KEY",details[0]);
                i.putExtra("DESCR_KEY",details[1]);
                        i.putExtra("IMAGE_KEY",details[2]);


        c.startActivity(i);


    }


}



