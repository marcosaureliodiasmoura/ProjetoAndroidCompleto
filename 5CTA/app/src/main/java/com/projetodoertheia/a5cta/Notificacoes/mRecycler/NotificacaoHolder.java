package com.projetodoertheia.a5cta.Notificacoes.mRecycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.projetodoertheia.a5cta.R;

import org.w3c.dom.Text;

/**
 * Created by Ertheia on 03/11/2017.
 */

public class NotificacaoHolder extends RecyclerView.ViewHolder {

    TextView titulo, subtitulo;
    ImageView imagem;
    CardView cardView;


    public NotificacaoHolder(View itemView) {
        super(itemView);

        titulo = (TextView) itemView.findViewById(R.id.item_TituloNotificacoes);
        subtitulo = (TextView) itemView.findViewById(R.id.item_SubtituloNotificacoes);
        imagem = (ImageView) itemView.findViewById(R.id.imageViewNotificações);
        cardView = (CardView)itemView.findViewById(R.id.cardviewlistaNotificacoes);

    }


}
