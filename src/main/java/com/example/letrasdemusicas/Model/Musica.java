package com.example.letrasdemusicas.Model;

import java.util.Collections;
import java.util.List;


public class Musica {
   private String titulo;
   private String id;
   private String genero;
   private String letra;
   private  List<String> artista;
   private String musicalink;
   private String capaLink;



    public Musica(String titulo, String id, String genero, String letra, String artista, String musicalink, String capaLink) {
        this.titulo = titulo;
        this.capaLink = capaLink;
        this.id = id;
        this.genero = genero;
        this.musicalink = musicalink;
        this.letra = letra;
        this.artista = Collections.singletonList(artista);
    }

    public Musica(String nome, String artista, String id) {

    }

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", id='" + id + '\'' +
                ", genero='" + genero + '\'' +
                ", letra='" + letra + '\'' +
                ", artista=" + artista +
                ", musicalink='" + musicalink + '\'' +
                ", capaLink='" + capaLink + '\'' +
                '}';
    }

    public String getCapaLink() {
        return capaLink;
    }

    public void setCapaLink(String capaLink) {
        this.capaLink = capaLink;
    }

    public String getMusicalink() {
        return musicalink;
    }

    public void setMusicalink(String musicalink) {
        this.musicalink = musicalink;
    }

    public List<String> getArtista() {
        return artista;
    }

    public void setArtista(List<String> artista) {
        this.artista = artista;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
