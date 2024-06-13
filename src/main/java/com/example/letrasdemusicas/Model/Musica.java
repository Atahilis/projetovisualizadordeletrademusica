package com.example.letrasdemusicas.Model;

import java.util.List;

public class Musica {
    private String titulo;
    private String id;
    private String letra;
    private List<String> artista;

    public Musica(String nome, String artista, String id) {
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", id='" + id + '\'' +
                ", letra='" + letra + '\'' +
                ", artista=" + artista +
                ", musicaLink='" + musicaLink + '\'' +
                ", capaLink='" + capaLink + '\'' +
                '}';
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

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public List<String> getArtista() {
        return artista;
    }

    public void setArtista(List<String> artista) {
        this.artista = artista;
    }

    public String getCapaLink() {
        return capaLink;
    }

    public void setCapaLink(String capaLink) {
        this.capaLink = capaLink;
    }

    public String getMusicaLink() {
        return musicaLink;
    }

    public void setMusicaLink(String musicaLink) {
        this.musicaLink = musicaLink;
    }

    private String musicaLink;

    public Musica(String titulo, String id, String letra, List<String> artista, String musicaLink, String capaLink) {
        this.titulo = titulo;
        this.id = id;
        this.letra = letra;
        this.artista = artista;
        this.musicaLink = musicaLink;
        this.capaLink = capaLink;
    }

    private String capaLink;

}   