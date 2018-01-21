package com.projetodoertheia.a5cta.Cursos.Calendario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.projetodoertheia.a5cta.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalendarioActivity extends AppCompatActivity {

    private List<String> listGroup;
//    private List<Integer> listGroupImage;
    private HashMap<String, List<String>> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        Toolbar tolbar = (Toolbar)findViewById(R.id.toolbarCalendario);
        tolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        buildList();


        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.expandirListView);
        expandableListView.setAdapter(new ExpandibleAdapter(CalendarioActivity.this,listGroup,listData));


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                Toast.makeText(CalendarioActivity.this, "Grupo: "+groupPosition+" | Item"+childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(CalendarioActivity.this, "Grupo (Expandir): "+groupPosition, Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(CalendarioActivity.this, "Grupo (Collapse): "+groupPosition, Toast.LENGTH_SHORT).show();

            }
        });


        expandableListView.setGroupIndicator(getResources().getDrawable(R.drawable.icon_group));



    }

    public void buildList(){
        listGroup = new ArrayList<String>();
//        listGroupImage = new ArrayList<Integer>();
        listData = new HashMap<String, List<String>>();

        listGroup.add("FEVEREIRO");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("MARÇO");
//        listGroupImage.add(R.drawable.i2);
        listGroup.add("ABRIL");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("MAIO");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("JUNHO");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("JULHO");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("AGOSTO");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("SETEMBRO");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("OUTUBRO");
//        listGroupImage.add(R.drawable.i1);
        listGroup.add("NOVEMBRO");
//        listGroupImage.add(R.drawable.i1);
//        listGroup.add("DEZEMBRO");


        //FILHOS (CHILDREN)
        List<String> auxList = new ArrayList<String>();
        auxList.add("Estágio de Linux Básico - EAD - FINALIZADO ");

        listData.put(listGroup.get(0),auxList);



        //MARÇO
        auxList = new ArrayList<String>();

        auxList.add("Estágio de LibreOffice - MARÇO/ABRIL - EAD - FINALIZADO ");
        auxList.add("Treinamento Prático dos Sistemas Corporativos - PRESENCIAL - FINALIZADO");
        auxList.add("Estágio de Manutenção de Micromcomputadores - PRESENCIAL - FINALIZADO");

        listData.put(listGroup.get(1),auxList);


        //ABRIL
        auxList = new ArrayList<String>();

        auxList.add("Estágio de Planilha Eletrônica com recursos avançados - EAD - FINALIZADO");
        auxList.add("Estágio de Telefonia - PRESENCIAL - FINALIZADO");

        listData.put(listGroup.get(2),auxList);



        //MAIO
        auxList = new ArrayList<String>();

        auxList.add("Estágio de SPED Usuário - EAD - FINALIZADO");
        auxList.add("Estágio de SISBOL Usuário - EAD - FINALIZADO ");

        listData.put(listGroup.get(3),auxList);


        //JUNHO
        auxList = new ArrayList<String>();

        auxList.add("Estágio de Redes TCP/IP e Cabeamento Estruturado - PRESENCIAL - FINALIZADO");
        auxList.add("HTML/CSS/JS- EAD - FINALIZADO");
        auxList.add("Estágio Básico de Manutenção e Montagem de Microcomputadores para alunos do CCOM CPOR/R (PCI) - PRESENCIAL - FINALIZADO");


        listData.put(listGroup.get(4),auxList);



        //JULHO
        auxList = new ArrayList<String>();

        auxList.add("Estágio de Redes de Computadores para os alunos do CCOM - CPOR/R (PCI) - PRESENCIAL");
        auxList.add("Estágio de LibreOffice - EAD");

        listData.put(listGroup.get(5),auxList);



        //AGOSTO
        auxList = new ArrayList<String>();

        auxList.add("Estágio de Seguranças em Redes e Sistemas - EAD/PRESENCIAL");
        auxList.add("Estágio de HTML/CSS/JS - EAD");

        listData.put(listGroup.get(6),auxList);


//        SETEMBRO
        auxList = new ArrayList<String>();
//
        auxList.add("Estágio de Manutenção de Microcomputadores - PRESENCIAL");

        listData.put(listGroup.get(7),auxList);


//        OUTUBRO
        auxList = new ArrayList<String>();
        auxList.add("Estágio de Telefonia - PRESENCIAL");
        listData.put(listGroup.get(8),auxList);

//        NOVEMBRO
        auxList = new ArrayList<String>();
        auxList.add("Estágio de Redes TCP/IP e Cabeamento Estruturado - PRESENCIAL");
        auxList.add("Estágio Básico de Manutenção e Montagem de Microcomputador para Cb/Sd NB/EV do 5º CTA - PRESENCIAL");
        auxList.add("Estágio de Linux Básico/LibreOffice para Cb/Sd NB/EV do 5º CTA - PRESENCIAL");
        listData.put(listGroup.get(9),auxList);














//        auxList = new ArrayList<String>();
//        auxList.add("item 9");
//        auxList.add("item 10");
//        auxList.add("item 11");
//        auxList.add("item 12");
//
//        listData.put(listGroup.get(2),auxList);
//
//
//        auxList = new ArrayList<String>();
//        auxList.add("item 13");
//        auxList.add("item 14");
//        auxList.add("item 15");
//        auxList.add("item 16");
//
//        listData.put(listGroup.get(3),auxList);



    }


}
