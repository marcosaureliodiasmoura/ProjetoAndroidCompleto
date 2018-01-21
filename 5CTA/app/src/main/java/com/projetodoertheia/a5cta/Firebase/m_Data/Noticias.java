package com.projetodoertheia.a5cta.Firebase.m_Data;

/**
 * Created by Marcos on 20/08/2016.
 */
public class Noticias {

    private String titulo;
    private String subtitulo;
    private String descricao2;
    private String imagemurl;


    public Noticias()
    {

    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getImagemurl() {
        return imagemurl;
    }

    public void setImagemurl(String imagemurl) {
        this.imagemurl = imagemurl;
    }

    public String getDescricao2() {
        return descricao2;
    }

    public void setDescricao2(String descricao2) {
        this.descricao2 = descricao2;
    }
}
