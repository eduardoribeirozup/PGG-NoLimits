package com.pgg.registrochave;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class RegistroChave implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RegistroChave.class, args);
    }

    @Override
    public void run(String[] args) {
        String entrada = "";
        LeitorComando leitor = null;

        try {
            for (int i = 0; i < args.length; i++) entrada += args[i] + " ";

            String comando = entrada.split(" ")[0];
            String chave = entrada.split("")[1];

            if (!(chave.equals("") || chave.equals(" "))) {
                switch (comando) {
                    case "set":
                        LeitorComando.setValor(chave);
                        break;
                    case "get":
                        System.out.println(LeitorComando.getValor(chave));
                        break;
                    case "delete":
                        LeitorComando.deleteValor(chave);
                        break;
                    case "list":
                        List<String> resultado = LeitorComando.listValor();
                        resultado.stream().forEach(System.out::println);
                        break;
                    default: System.out.println("O comando não foi encontrado...");
                }
            } else System.out.println("Não foi possível selecionar a chave...");
        } catch (Exception e) {
            System.out.println("Ocorreu o seguinte erro: " + e);
        }
    }
}