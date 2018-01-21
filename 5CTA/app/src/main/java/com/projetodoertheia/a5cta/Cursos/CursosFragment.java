package com.projetodoertheia.a5cta.Cursos;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.projetodoertheia.a5cta.Cursos.VideoAulas.Aula1Activity;
import com.projetodoertheia.a5cta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CursosFragment extends android.support.v4.app.Fragment implements View.OnClickListener{

    Button botao_Calendario;
    Button botao_EAD;
    Button botao_Matricula;
    Button btn17, btn18, btn19, btn20, btn21, btn22, btn23;


    private final VideosFragment videosFragment = new VideosFragment();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_cursos, container, false);


        if(container == null)
        {
            return null;
        }



        botao_Calendario = (Button) rootview.findViewById(R.id.btn_calendario);
        botao_Calendario.setOnClickListener((View.OnClickListener) this);


        botao_EAD = (Button) rootview.findViewById(R.id.btn_ead);
        botao_EAD.setOnClickListener((View.OnClickListener) this);


        botao_Matricula = (Button) rootview.findViewById(R.id.btn_matricula);
        botao_Matricula.setOnClickListener((View.OnClickListener) this);


        btn17 = (Button)rootview.findViewById(R.id.button17);
        btn17.setOnClickListener((View.OnClickListener)this);

        btn18 = (Button)rootview.findViewById(R.id.button18);
        btn18.setOnClickListener((View.OnClickListener)this);

        btn19 = (Button)rootview.findViewById(R.id.button19);
        btn19.setOnClickListener((View.OnClickListener)this);

        btn20 = (Button)rootview.findViewById(R.id.button20);
        btn20.setOnClickListener((View.OnClickListener)this);

        btn21 = (Button)rootview.findViewById(R.id.button21);
        btn21.setOnClickListener((View.OnClickListener)this);

        btn22 = (Button)rootview.findViewById(R.id.button22);
        btn22.setOnClickListener((View.OnClickListener)this);

        btn23 = (Button)rootview.findViewById(R.id.button23);
        btn23.setOnClickListener((View.OnClickListener)this);











        return rootview;

    }


//    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_calendario:

                Intent it1 = new Intent(this.getActivity(), com.projetodoertheia.a5cta.Cursos.Calendario.CalendarioActivity.class);
                startActivity(it1);
                break;


            case R.id.btn_ead:

                Intent it2 = new Intent(this.getActivity(), EadActivity.class);
                startActivity(it2);
                break;

            case R.id.btn_matricula:
                Intent it3 = new Intent(this.getActivity(), OpenMatriculaActivity.class);
                startActivity(it3);
                break;


            case R.id.button17:
                Intent it4 = new Intent(this.getActivity(), Aula1Activity.class);
                startActivity(it4);
                break;


        }

        }

}
