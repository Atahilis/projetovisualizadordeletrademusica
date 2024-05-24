package com.example.letrasdemusicas.Model;


import java.io.*;
import java.nio.Buffer;

public class UsuarioDao {

    public void salvar(Usuario usuario) throws IOException {

        FileWriter writer = new FileWriter("usuarios.txt", true);
        writer.write(usuario.getNome() + "," + usuario.getSenha() + System.lineSeparator());

        writer.close();
    }

    public static Usuario ler(String nome, String senha) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt")); {
        String linha;
        while ((linha = reader.readLine()) != null){
            String[] usuarioSeparado = linha.split(",");

            if (usuarioSeparado[0].equals(nome) && usuarioSeparado[1].equals(senha)){
                return new Usuario(usuarioSeparado[0], usuarioSeparado[1]);

            }
        }
        }
        return null;
    }

}
