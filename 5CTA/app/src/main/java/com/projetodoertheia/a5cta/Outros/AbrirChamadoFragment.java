package com.projetodoertheia.a5cta.Outros;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.projetodoertheia.a5cta.R;

/**
 * Created by Marcos on 17/09/2016.
 */
public class AbrirChamadoFragment extends Fragment implements View.OnClickListener {

    Button btnAbrirChamado;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_abrir_chamado, container, false);

        btnAbrirChamado = (Button)rootview.findViewById(R.id.botaoContinuarChamado);
        btnAbrirChamado.setOnClickListener(this);

        if (container == null) {
            return null;
        }
        return rootview;
    }

    @Override
    public void onClick(View v) {

        Intent it1 = new Intent(this.getActivity(), AbrirChamadoActivity.class);
        startActivity(it1);
    }
}
