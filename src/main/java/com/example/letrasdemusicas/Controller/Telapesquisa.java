package com.example.letrasdemusicas.Controller;

import com.example.letrasdemusicas.Model.Musica;
import com.example.letrasdemusicas.Model.MusicaDao;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Telapesquisa {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField barraPesquisa;

    @FXML
    private JFXButton buscar;

    @FXML
    private ListView<Musica> listaDeMusicas;

    @FXML
    void barraPesquisaAction(ActionEvent event) {


    }

    @FXML
    void buscarAction(ActionEvent event) {
        String musicaPesquisada = barraPesquisa.getText();

        MusicaDao musicaDao = new MusicaDao();

        try{

            List<Musica> musicasRetornadas = musicaDao.pesquisarMusica(musicaPesquisada);

            ObservableList<Musica> listaMusicas = FXCollections.observableArrayList(musicasRetornadas);

            listaDeMusicas.setItems(listaMusicas);


        } catch (IOException | ParseException e) {
            System.out.println("Erro ao pesquisar música");

        }


    }

    @FXML
    void clicar(MouseEvent event) {
        Musica musicaSelecionada = listaDeMusicas.getFocusModel().getFocusedItem();

        try{
            new MusicaDao().pegarLetra(musicaSelecionada);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/letrasdemusicas/view/telaLetra.fxml"));
            Parent root = loader.load();

            telaLetra telaLetra = loader.getController();
            telaLetra.iniciar(musicaSelecionada);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);


        } catch ( IOException | ParseException e){
            System.out.println("Erro ao buscar letra");
        }
    }

}