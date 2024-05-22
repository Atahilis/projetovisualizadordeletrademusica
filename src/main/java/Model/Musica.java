package Model;

public class Musica {
    String titulo;
    int id;
    String genero;
    String compositor;
    String letra;
    String artista;

    public Musica(int id){
        this.id=id;
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
