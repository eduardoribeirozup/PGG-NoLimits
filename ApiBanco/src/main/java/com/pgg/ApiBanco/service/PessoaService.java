package com.pgg.ApiBanco.service;

import com.pgg.ApiBanco.model.Pessoa;
import com.pgg.ApiBanco.repositories.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepositorio repo;

    public void postArquivo(Pessoa p) {
        repo.save(p);
    }

    public Iterable<Pessoa> getArquivo() {
        return repo.findAll();
    }

    public void deleteArquivo(long id) {
        repo.deleteById(id);
    }

    public void putArquivo(long id, Pessoa p) {
        Optional<Pessoa> novaPessoa = repo.findById(id);
        if (novaPessoa.isPresent()) {
            p.setId(id);
            postArquivo(p);
        }
    }
}
