package com.pgg.requisicaohttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequisicaoHTTP {
    public static String retornaRequisicao(String link, String jsonString) throws MalformedURLException, IOException {       
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
            String responseLine;
            StringBuilder response = new StringBuilder();
                        
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            
            return response.toString();
        }
    }
}
