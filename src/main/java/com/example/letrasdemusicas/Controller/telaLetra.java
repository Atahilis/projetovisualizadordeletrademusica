package com.example.letrasdemusicas.Controller;

import com.example.letrasdemusicas.Model.Musica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class telaLetra {

    @FXML
    private Button Voltar;

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

    @FXML
    public void VoltarAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/letrasdemusicas/view/Telapesquisa.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}