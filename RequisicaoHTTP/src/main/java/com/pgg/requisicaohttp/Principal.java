package com.pgg.requisicaohttp;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException  {
        String post = "http://httpbin.org/post";
        String json = "{ \"id\": 123, \"field\": \"testing\"}";
        System.out.println(RequisicaoHTTP.retornaRequisicao(post, json));
        
        String delete = "http://httpbin.org/delete";        
        System.out.println(RequisicaoHTTP.deletaRequisicao(delete));        
    }
}
