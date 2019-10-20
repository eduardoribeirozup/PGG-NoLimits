package com.company;

//Importações necessárias à aplicação
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

//Classe principal
public class Main {

    //Método principal
    public static void main(String[] args) {

        //Objeto para entrada de string
        Scanner ent = new Scanner(System.in);
        System.out.print("Digite o caminho da pasta que você quer listar: ");
        String caminho = ent.next();

        //Captura de exceções
        try {
            Files.find(Paths.get(caminho), Integer.MAX_VALUE, (filePath, fileAttr) -> fileAttr.isRegularFile()).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Não foi possível listar os diretórios do caminho apresentado. Todas as pastas tem permissão?");
        }
    }
}
