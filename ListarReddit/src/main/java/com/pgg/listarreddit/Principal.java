package com.pgg.listarreddit;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Principal {
     public static void main(String[] args) throws IOException{
         List <String> titulos = ListarTopicos.retornaTopicos();
         
         Collections.sort(titulos);
         
         System.out.println("Foram encontados " + titulos.size() + " tópicos no /r/programming");
         
         for (int contador = 0; contador < titulos.size(); contador++)
            System.out.println(titulos.get(contador));
    }
}
