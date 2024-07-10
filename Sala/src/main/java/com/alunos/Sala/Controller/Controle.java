package com.alunos.Sala.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alunos.Sala.Model.Aluno;
import com.alunos.Sala.Repository.Repositorio;
import com.alunos.Sala.Services.Servicos;

@RestController
public class Controle {
    @Autowired
    Repositorio acao;

    @Autowired
    Servicos servicos;

    @GetMapping()
    public String comprimentos(){
        return "Ola, seja bem vindo";
    }

    //salvar
    @PostMapping("/salvar")
    public ResponseEntity<?> cadastrar(@RequestBody Aluno aluno){
        return servicos.cadastrar(aluno);
    }

    //selecionar e mostrar
    @GetMapping("/mostrarSelecionado/{codigoId}")
    public ResponseEntity <?> selecionar(@PathVariable Integer codigoId){
        return servicos.mostrarSelecionado(codigoId);
    }

    //mostrar toda a lista
    @GetMapping("/mostrarLista")
    public ResponseEntity<List<Aluno>> mostrarLista(){
        return (ResponseEntity<List <Aluno>>) servicos.mostrarLista();
    }

    //Deletar Selecionado
    @DeleteMapping("/apagar/{codigoId}")
    public void deletarSelecionado(@PathVariable Integer codigoId){
        servicos.deletar(codigoId);
    }

    //vai apagar tudo do banco de dados
    @DeleteMapping("/apagarTudo")
    public void deletarTudo(){
        servicos.deletarTudo();
    }

    //lista ordenada de A ate Z
    @GetMapping("/listaOrdenadaAZ")
    public ResponseEntity<List <Aluno>> listaOrdenadaAZ(){
        return (ResponseEntity<List <Aluno>>) servicos.listaOrdenadaAZ();
    }

    @GetMapping("/listaOrdenadaZA")
    public ResponseEntity<List <Aluno>> listaOrdenadaZA() {
        return (ResponseEntity<List <Aluno>>) servicos.listaOrdenadaZA();
    }

    //busca palavra
    @GetMapping("/buscaPalavra/{palavra}")
    public ResponseEntity<List <Aluno>> buscaPalavra(@PathVariable String palavra){
        return (ResponseEntity<List <Aluno>>) servicos.buscaPalavra(palavra);
    }

    //contador de quantos obj tem na lista
    @GetMapping("/contador")
    public Long contador(){
        return acao.count();
    }

    @PutMapping("substituirObj")
    public ResponseEntity<Aluno> substituirObj(Aluno obj){
        return (ResponseEntity<Aluno>) servicos.substituirObj(obj);
    }

    @GetMapping("/letraInicial")
    public ResponseEntity<List <Aluno>> buscaInicial(String letraInicial){
        return (ResponseEntity<List <Aluno>>) servicos.buscaInicial(letraInicial);
    }

    @GetMapping("/letraFinal")
    public ResponseEntity<List <Aluno>> buscaFinal(String letraFinal){
        return (ResponseEntity<List <Aluno>>) servicos.buscaFinal(letraFinal);
    }
}
