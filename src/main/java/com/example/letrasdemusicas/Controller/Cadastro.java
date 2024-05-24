package com.example.letrasdemusicas.Controller;

import com.example.letrasdemusicas.Model.Usuario;
import com.example.letrasdemusicas.Model.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Cadastro {

    @FXML
    private TextField botaoNome;

    @FXML
    private Button botaoSalvar;

    @FXML
    private TextField botaoSenha;

    @FXML
    private Label mensagemAindaNaoPossuiConta;

    @FXML
    private Label mensagemCadastrar;

    @FXML
    void botaoNomeAcao(ActionEvent event) {

    }

    @FXML
    void botaoSalvarAcao(ActionEvent event) throws IOException {
        String nomeDigitado = botaoNome.getText();
        String senhaDigitada = botaoSenha.getText();
        Usuario usuario = new Usuario(nomeDigitado, senhaDigitada);
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.salvar(usuario);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/letrasdemusicas/view/Telapesquisa.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void botaoSenhaAcao(ActionEvent event) {

        
    }

}
