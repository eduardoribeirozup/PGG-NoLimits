package com.pgg.registrochave;

import com.pgg.registrochave.source.LeitorComando;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class RegistroChave implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(RegistroChave.class, args);
	}

    @Override
    public void run(String[] args) throws Exception {
		LeitorComando leitor = new LeitorComando();

		String comando = args[0];
	    String chave = args[1];

		switch (comando) {
			case "set":
				leitor.setValor(chave);
				break;
			case "get":
				System.out.println(leitor.getValor(chave));
				break;
			case "delete":
				leitor.deleteValor(chave);
				break;
			case "list":
				List<String> resultado = leitor.listValor();
				resultado.stream().forEach(System.out::println);
				break;
			default:
				System.out.println("O comando não foi encontrado...");
		}

    }
}
