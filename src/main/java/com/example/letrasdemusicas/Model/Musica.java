package com.example.letrasdemusicas.Model;

public class Musica {
   private String titulo;
   private int id;
   private String genero;
   private String compositor;
   private String letra;
   private String artista;

    public Musica(String titulo, int id, String genero, String compositor, String letra, String artista) {
        this.titulo = titulo;
        this.id = id;
        this.genero = genero;
        this.compositor = compositor;
        this.letra = letra;
        this.artista = artista;
        
    }

    public Musica(String nome, String artista, String id) {

    }

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", id=" + id +
                ", genero='" + genero + '\'' +
                ", compositor='" + compositor + '\'' +
                ", letra='" + letra + '\'' +
                ", artista='" + artista + '\'' +
                '}';
    }

    
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}