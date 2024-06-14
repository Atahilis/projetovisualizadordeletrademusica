package com.example.letrasdemusicas.Model;


import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Closeable;
import java.io.IOException;
import org.apache.hc.core5.http.ParseException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MusicaDao {
    private final String CLIENT_ID = "77fefb73700847eb97963572bb03528e";
    private final String SECRET_CLIENTE = "fc2e815c420c4081bafc86f27feb6665";
    private final String URL_BASE = "https://api.spotify.com/v1";
    private final String TOKEN_URL = "https://accounts.spotify.com/api/token";
    private String tokenAcesso;

    private void pegarToken() throws IOException, ParseException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(TOKEN_URL);

            List<BasicNameValuePair> parametros = new ArrayList<>();

            parametros.add(new BasicNameValuePair("grant_type", "client_credentials"));
            parametros.add(new BasicNameValuePair("client_id", CLIENT_ID));
            parametros.add(new BasicNameValuePair("client_secret", SECRET_CLIENTE));


            post.setEntity(new UrlEncodedFormEntity(parametros));

            try (CloseableHttpResponse response = httpClient.execute(post)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = new JSONObject(responseBody);
                this.tokenAcesso = jsonObject.getString("access_token");


            }
        }
    }

     public void pegarLetra(Musica musica) throws IOException, ParseException{
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
         final String URL_LYRICS_OVH = "https://api.lyrics.ovh/v1/";

         String urlPesquisa = URL_LYRICS_OVH + URLEncoder.encode(musica.getArtista().getFirst(), StandardCharsets.UTF_8)
         + "/" + URLEncoder.encode(musica.getTitulo(), StandardCharsets.UTF_8);

         HttpGet get = new HttpGet(urlPesquisa);

         try (CloseableHttpResponse response = httpClient.execute(get)){
             String corpoResponse = EntityUtils.toString(response.getEntity());

             JSONObject resultadoPesquisa = new JSONObject(corpoResponse);

             try{
                 String letra = resultadoPesquisa.getString("lyrics");
                 musica.setLetra(letra);

             } catch (JSONException e){

                 musica.setLetra("Não foi possivel encontrar a letra dessa música");
             }
         }
        }
     }



    public List<Musica> pesquisarMusica(String nomeMusica) throws IOException, ParseException {
        pegarToken();
        List<Musica> listaMusicas = new ArrayList<>();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            String urlPesquisa = URL_BASE + "/search?q=" + URLEncoder.encode(nomeMusica, StandardCharsets.UTF_8) + "&type=tracks&limit=15";
       HttpGet get = new HttpGet(urlPesquisa);
       get.setHeader("Authorization", "Bearer " + tokenAcesso);

       try (CloseableHttpResponse response = httpClient.execute(get)){

           String corpoResponse = EntityUtils.toString(response.getEntity());
           JSONObject resultadosPesquisa = new JSONObject(corpoResponse);
           JSONArray tracks = resultadosPesquisa.getJSONObject("tracks").getJSONArray("items");

           for (int i = 0; i < tracks.length(); i++){
              JSONObject musica = tracks.getJSONObject(i);
              String id = musica.getString("id");
              String nome = musica.getString("name");
              String artista = musica.getJSONArray("artists").getJSONObject(0).getString("name");
              listaMusicas.add(new Musica(nome, artista, id));

           }
          }
        }
        return listaMusicas;
    }
}
