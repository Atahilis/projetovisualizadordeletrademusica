package com.example.letrasdemusicas.Controller;

import javafx.scene.Parent;
import javafx.scene.Node;
import com.example.letrasdemusicas.Model.Usuario;
import com.example.letrasdemusicas.Model.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

        @FXML
        private Button cadastro;

        @FXML
        private Button login;

        @FXML
        private PasswordField senha;

        @FXML
        private TextField user;

        @FXML
        private ImageView logoImageView;

        @FXML
        void cadastroAction(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/letrasdemusicas/view/Cadastro.fxml"));
           Parent root = loader.load();
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           Scene scene = new Scene(root);
           stage.setScene(scene);

        }

        @FXML
        void loginAction(ActionEvent event) throws IOException {
        String nomeDigitado = user.getText();
        String senhaDigitada= senha.getText();

        UsuarioDao usuarioDao = new UsuarioDao();

        Usuario usuario = null;
        try {
             usuario = UsuarioDao.ler(nomeDigitado, senhaDigitada);

        } catch (IOException | ArrayIndexOutOfBoundsException e){

        }

        if (usuario != null)  {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/letrasdemusicas/view/Telapesquisa.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
        }
        }

    }


