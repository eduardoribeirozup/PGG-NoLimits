package com.pgg.registrochave;

import java.io.*;
import java.util.*;

public class LeitorComando {
    public static File arquivo = new File("arquivo.txt");

    public static void setValor(String chave) {
        try {
            if (arquivo.exists()) {
                try (FileWriter escrita = new FileWriter(arquivo, true)) {
                    try (BufferedWriter buffer = new BufferedWriter(escrita)) {
                        try (PrintWriter saida = new PrintWriter(buffer)) {
                            saida.println(chave);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Não foi possível gravar no arquivo...");
                }
            } else {
                PrintWriter texto = new PrintWriter(arquivo.getPath());
                texto.println(chave);
                texto.close();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro no aquivo.");
        }
    }

    public static String getValor(String chave) throws IOException {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
            String linha = "";

            while (linha != null) {
                linha = buffer.readLine();

                if (chave.equals(linha.split(":")[0])) return linha.split(":")[1];
            }

            buffer.close();
            return "";
        } catch (IOException e) {
            return "Não foi possível realizar a ação. Exceção: " + e;
        }
    }

    public static void deleteValor(String chave) {
        String linha = null;
        StringBuilder conteudoArquivo = new StringBuilder();

        try (BufferedReader buffReader = new BufferedReader(new FileReader(arquivo))) {
            while ((linha = buffReader.readLine()) != null) {
                String[] arrayLinha = linha.split(":");
                if (!arrayLinha[0].equals(chave)) conteudoArquivo.append(linha + "\r\n");
            }
            try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(arquivo))) {
                buffWriter.write(conteudoArquivo.toString());
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static List<String> listValor() throws IOException {
        List<String> linhas = new ArrayList<String>();
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
            String linha;

            while ((linha = buffer.readLine()) != null) linhas.add(linha);

            buffer.close();
            return linhas;
        } catch (IOException e) {
            linhas.add("Não foi possível realizar a ação. Exceção: " + e);
            return linhas;
        }
    }
}
