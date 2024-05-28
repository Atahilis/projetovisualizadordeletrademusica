package com.example.letrasdemusicas;

import com.example.letrasdemusicas.Model.Musica;
import com.example.letrasdemusicas.Model.MusicaDao;
import com.example.letrasdemusicas.Model.Usuario;
import com.example.letrasdemusicas.Model.UsuarioDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ParseException {





        MusicaDao musicaDao = new MusicaDao();
        List<Musica> musicas = musicaDao.pesquisarMusica("perfect");
        musicas.forEach(System.out::println);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/letrasdemusicas/view/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Bem vindo!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
