package com.projetodoertheia.a5cta.Contatos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcos on 02/08/2016.
 */
public class ListData {

    private static final String[] titles = {"Auto Atendimento", "Seção de Comunicação Social", "AGO", "Divisão Administrativa",
    "Seção de Controle e Material e Patrimônio", "Almoxarifado", "Reserva de Material Carga", "Seção de Manutenção e Transporte",
    "Seção de Contratos e Licitações" , "Seção de Serviços Gerais", "Divisão de Pessoal","Seção de Inteligência", "Seção de Pessoal",
    "Seção de Contigente", "Divisão Técnica", "Seção de Treinamento", "Seção de Projetos", "Seção de Gerência", "Seção de Sistemas",
    "Divisão de Operação", "Seção de Rede Telefônica", "Seção de Manutenção", "Seção de Rede Rádio", "Seção de Atendimento ao Usuário",
    "Seção de Rede de Dados", "Seção de Segurança"};

    private static final int[] icones = {
            };

//    private static final String[] subtitulos = {"Atendimento de entrada da OM", "dois", "dez"};

    private static final String[] telefone = {"21296470", "21296585", "21296498", "21296479", "21296478", "21296591", "21296590", "21296478",
    "21296485", "21296595", "21297154", "21296586", "21296474", "21296497", "21296490", "21296596", "21296587", "21296430", "21296473",
    "2129", "21297115", "21296484", "21296581", "21296143", "21296580", "21296477", "21296480"};



    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();

        for (int x = 0; x < 1; x++) {
//            && i < icones.length;
            for (int i = 0; i < titles.length; i++) {

                ListItem item = new ListItem();
//                item.setImageResID(icones[i]);
                item.setTitulo(titles[i]);
//                item.setSubtitulo(subtitulos[i]);
                item.setTelefone(telefone[i]);
                data.add(item);
            }
        }
        return data;
    }
}
