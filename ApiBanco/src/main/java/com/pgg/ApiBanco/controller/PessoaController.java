package com.pgg.ApiBanco.controller;

import com.pgg.ApiBanco.model.Pessoa;
import com.pgg.ApiBanco.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoa;

    @PostMapping
    public void postPessoa(@RequestBody @Valid Pessoa p) {
        pessoa.postArquivo(p);
    }

    @GetMapping
    public Iterable<Pessoa> getPessoa() {
        return pessoa.getArquivo();
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void deletePessoa(@PathVariable long id) {
        pessoa.deleteArquivo(id);
    }

    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    public void putPessoa(@RequestBody @Valid Pessoa p, @PathVariable long id) {
        pessoa.putArquivo(id, p);
    }
}
