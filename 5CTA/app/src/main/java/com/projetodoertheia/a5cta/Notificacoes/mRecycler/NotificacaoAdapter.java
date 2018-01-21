package com.projetodoertheia.a5cta.Notificacoes.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.projetodoertheia.a5cta.Notificacoes.mData.Notificacao;
import com.projetodoertheia.a5cta.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ertheia on 03/11/2017.
 */

public class NotificacaoAdapter extends RecyclerView.Adapter<NotificacaoHolder> {

    Context c;
    ArrayList<Notificacao> notificacoes;


    public NotificacaoAdapter(Context c, ArrayList<Notificacao> notificacoes) {
        this.c = c;
        this.notificacoes = notificacoes;
    }

    @Override
    public NotificacaoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notificacoes,parent, false);
        NotificacaoHolder notificacaoHolder = new NotificacaoHolder(v);
        return notificacaoHolder;
    }

    @Override
    public void onBindViewHolder(NotificacaoHolder holder, int position) {
    holder.titulo.setText(notificacoes.get(position).getTitulo());
    holder.subtitulo.setText(notificacoes.get(position).getSubtitulo());
        YoYo.with(Techniques.FadeInDown).duration(2500).playOn(holder.cardView);
        final Notificacao no = notificacoes.get(position);
        Picasso.with(this.c).load(no.getImagemurl()).into(holder.imagem);


    }

    @Override
    public int getItemCount() {
        return notificacoes.size();
    }
}
