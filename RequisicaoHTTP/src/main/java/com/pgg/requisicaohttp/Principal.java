package com.pgg.requisicaohttp;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException  {
        String link = "http://httpbin.org/post";
        String json = "{ \"id\": 123, \"field\": \"testing\"}";
        
        System.out.print(RequisicaoHTTP.retornaRequisicao(link, json));
    }
}
