package com.example.letrasdemusicas.Model;
//comentario teste!!!!


public class Musica {
   private String titulo;
   private String id;
   private String genero;
   private String compositor;
   private String letra;
   private String artista;

    public Musica(String titulo, String id, String genero, String compositor, String letra, String artista) {
        this.titulo = titulo;
        this.id = id;
        this.genero = genero;
        this.compositor = compositor;
        this.letra = letra;
        this.artista = artista;
        
    }

    public Musica(String titulo, String artista, String id) {
        this.titulo = titulo;
        this.artista = artista;
        this.id = id;


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
