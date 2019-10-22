package com.pgg.requisicaohttp;

import java.io.*;
import java.net.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

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
       
    public static String deletaRequisicao(String url) throws IOException {
        try (CloseableHttpClient cliente = HttpClients.createDefault()) {
            HttpDelete delecao = new HttpDelete(url);

            delecao.getRequestLine();

            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = cliente.execute(delecao, responseHandler);
            
            return responseBody;
        }
    }
}
