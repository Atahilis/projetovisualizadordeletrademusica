package com.example.letrasdemusicas.Controller;

import com.example.letrasdemusicas.Model.Musica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TelaLetra {

    @FXML
    private ImageView capa;

    @FXML
    private Label MusicaArtista;

    @FXML
    public TextArea letrasArea;

    @FXML
    private Hyperlink spotifyLink;

    private Musica musica;

    public void iniciar(Musica musica) {
        this.musica = musica;

        String nomeMusicaArtista = musica.getTitulo() + "\n" + musica.getArtista();

        MusicaArtista.setWrapText(true);
        MusicaArtista.setText(nomeMusicaArtista);

        letrasArea.setText(this.musica.getLetra());

        Image imagemCapa = new Image(this.musica.getCapaLink());

        capa.setImage(imagemCapa);
    }

    @FXML
    void spotifyLinkAction(ActionEvent event) {
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.browse(new URI(musica.getMusicalink()));
        } catch (IOException | URISyntaxException e) {
            System.out.println("Erro ao abrir link");
        }
    }

}