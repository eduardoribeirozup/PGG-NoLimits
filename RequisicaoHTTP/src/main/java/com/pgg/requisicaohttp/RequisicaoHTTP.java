package com.pgg.requisicaohttp;

import java.io.*;
import java.net.*;

public class RequisicaoHTTP {
    public static String retornaRequisicao(String link, String jsonString) throws IOException {
        URL url = new URL(link);
        HttpURLConnection conexao = (HttpURLConnection)url.openConnection();
        
        conexao.setRequestMethod("POST");
        conexao.setRequestProperty("Content-Type", "application/json; utf-8");
        conexao.setRequestProperty("Accept", "application/json");
        conexao.setDoOutput(true);
        
        try(OutputStream output = conexao.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            output.write(input, 0, input.length);           
        }
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream(), "utf-8"))) {
            String linha;
            StringBuilder resposta = new StringBuilder();
                        
            while ((linha = br.readLine()) != null) {
                resposta.append(linha.trim());
            }
            
            return resposta.toString();
        }
    }
       
    public static String deletaRequisicao(String link) {
        try {
            String auxiliar = null;
            StringBuilder retorno = new StringBuilder();

            URL url = new URL(link);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            conexao.setDoOutput(true);
            conexao.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            conexao.setRequestMethod("DELETE");
            conexao.connect();

            BufferedReader linha = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            while((auxiliar = linha.readLine()) != null){
                retorno.append(auxiliar).append(" ");
            }

           return retorno.toString();
        } catch (Exception e) {
            System.out.println("Não foi possível realizar a operação: " + e);
        }

        return null;
    }
    
    public static String autenticaRequisicao(String link) throws MalformedURLException, IOException {
        URL url = new URL(link);
        HttpURLConnection conexao = (HttpURLConnection)url.openConnection();

        conexao.setRequestProperty("Authorization","Bearer "+" Actual bearer token issued by provider.");

        conexao.setRequestProperty("Content-Type","application/json");
        conexao.setRequestMethod("GET");

        StringBuffer response;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
            String output;
            response = new StringBuffer();
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
        }
        
        return response.toString();
    }
}
