package com.alunos.Sala.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
    //id do metodo que sera localizado
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codigoId;

    private String nome;
    private Integer idade;
    private String serie;

    public Aluno(){
        this.nome = "Sem nome";
        this.idade = -1;
        this.serie = null;
        
        this.codigoId = 0;
    }

    public Integer getCodigoId() {
        return codigoId;
    }
    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
