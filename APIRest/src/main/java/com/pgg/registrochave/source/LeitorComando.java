package com.pgg.registrochave.source;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorComando {
    private File arquivo = new File("arquivo.txt");

    public void setValor(String chave) throws IOException {
        if (arquivo.exists()) {
            try (FileWriter escrita = new FileWriter("arquivo.txt", true)) {
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
    }

    public String getValor(String chave) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader("arquivo.txt"));
        String linha = "";

        while (linha != null) {
            linha = buffer.readLine();

            if (chave.equals(linha.split(":")[0])) {
                return linha.split(":")[1];
            }
        }

        buffer.close();
        return "";
    }

    public void deleteValor(String chave) {
        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader bufferLeitor = new BufferedReader(leitor);

            ArrayList<String> salvar = new ArrayList<String>();

            String linha;
            while ((linha = bufferLeitor.readLine()) != null) {
                if (!linha.equals((chave + getValor(chave)))) {
                    salvar.add(linha);
                }
            }
            leitor.close();
            bufferLeitor.close();

            FileWriter escritor = new FileWriter(arquivo);
            BufferedWriter bufferEscritor = new BufferedWriter(escritor);

            for (int i = 0; i < salvar.size(); i++) {
                bufferEscritor.write(salvar.get(i));
                bufferEscritor.newLine();
            }

            bufferEscritor.close();
            escritor.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<String> listValor() throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader("arquivo.txt"));
        List<String> linhas = new ArrayList<>();
        String linha;

        while ((linha = buffer.readLine()) != null) {
            linhas.add(linha);
        }

        buffer.close();
        return linhas;
    }
}
