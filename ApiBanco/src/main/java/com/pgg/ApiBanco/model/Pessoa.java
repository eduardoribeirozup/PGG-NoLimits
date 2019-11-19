package com.pgg.ApiBanco.model;

//Imports para persistência dos dados
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Anotações para identificar uma Entidade e uma tabela no banco
@Entity
//O nome da tabela deverá ser "Pessoa"
@Table (name = "Pessoa")
public class Pessoa {
    //ID principal da tabela
    @Id
    private long id;

    //Campos das tabelas
    private String nome;
    private String CPF;

    //Construtor com todas as propriedades
    public Pessoa(long id, String nome, String CPF) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
    }
    //Construtor sem nenhuma propriedade
    public Pessoa() { }

    //Getters e Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
