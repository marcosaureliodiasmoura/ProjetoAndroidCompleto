package com.projetodoertheia.a5cta.Contatos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.projetodoertheia.a5cta.R;
import com.projetodoertheia.a5cta.Contatos.model.ListItem;

import java.util.List;

/**
 * Created by Marcos on 02/08/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {


    private List<ListItem> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);
        void onItemSecundaryClick(int p);
    }

    public void setItemClickCallback (final ItemClickCallback itemClickCallback)
    {
        this.itemClickCallback = itemClickCallback;
    }

    public ListAdapter(List<ListItem> listData, Context c )
    {
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {

        ListItem item = listData.get(position);
        holder.tituloHolder.setText(item.getTitulo());
//        holder.iconeHolder.setImageResource(item.getImageResID());
        holder.texto_telefone.setText(item.getTelefone());
//        holder.subtitulo_Holder.setText(item.getSubtitulo());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView tituloHolder;
//        private ImageView iconeHolder;
        private View contadorHolder;
//        private TextView subtitulo_Holder;
        private ImageButton botao_Holder;
        private TextView texto_telefone;


        public ListHolder(View itemView) {
            super(itemView);


            tituloHolder = (TextView)itemView.findViewById(R.id.item_Titulo);
//            iconeHolder = (ImageView)itemView.findViewById(R.id.item_Icone);
            contadorHolder = itemView.findViewById(R.id.contadorListItem);
            contadorHolder.setOnClickListener(this);
            botao_Holder = (ImageButton) itemView.findViewById(R.id.btn_acao);
            botao_Holder.setOnClickListener(this);
//            subtitulo_Holder = (TextView)itemView.findViewById(R.id.item_Subtitulo);
            texto_telefone = (TextView)itemView.findViewById(R.id.item_telefone);
        }

        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.contadorListItem)
            {

                itemClickCallback.onItemClick(getAdapterPosition());


            }else {
                itemClickCallback.onItemSecundaryClick(getAdapterPosition());
            }



        }
    }
}
