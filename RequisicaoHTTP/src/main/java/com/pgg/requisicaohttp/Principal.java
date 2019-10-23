package com.pgg.requisicaohttp;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException  {
        String post = "http://httpbin.org/post";
        String json = "{ \"id\": 123, \"field\": \"testing\"}";
        System.out.println("O retorno da requisição HTTP(POST) é: " + RequisicaoHTTP.retornaRequisicao(post, json));

        System.out.print("-------------------------------------\n");

        String delete = "http://httpbin.org/delete";
        System.out.println("O retorno da requisição HTTP(DELETE) é: " + RequisicaoHTTP.deletaRequisicao(delete));

        System.out.print("-------------------------------------\n");

        String link = "http://httpbin.org/bearer";
        System.out.print("O retorno da autenticação bearer é: " + RequisicaoHTTP.autenticaRequisicao(link));
    }
}
