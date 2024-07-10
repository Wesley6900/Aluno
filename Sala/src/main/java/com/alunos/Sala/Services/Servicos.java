package com.alunos.Sala.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alunos.Sala.Model.Aluno;
import com.alunos.Sala.Model.Mensagem;
import com.alunos.Sala.Repository.Repositorio;

import jakarta.transaction.Transactional;

@Service
public class Servicos {
    @Autowired
    Repositorio acao;

    @Autowired
    Mensagem mensagemC;

    public ResponseEntity<?> cadastrar(Aluno obj){
        if(obj.getNome().equals("Sem nome") || obj.getNome() == null){
            mensagemC.setMensagemGerada("Não deixe o nome em branco!");
            return new ResponseEntity<>(mensagemC.getMensagemGerada(), HttpStatus.BAD_REQUEST);
        }else if(obj.getIdade() < 0 || obj.getIdade() == 0){
            mensagemC.setMensagemGerada("Idade Invalida!");
            return new ResponseEntity<>(mensagemC.getMensagemGerada(), HttpStatus.BAD_REQUEST);
        }else if(obj.getSerie().isEmpty() || obj.getSerie() == null){
            mensagemC.setMensagemGerada("Serie Vazia! digite qual serie o aluno esta!");
            return new ResponseEntity<>(mensagemC.getMensagemGerada(), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> mostrarSelecionado(Integer codigoId){
        if(codigoId < 0){
            mensagemC.setMensagemGerada("Essa numeração de Id não existe no banco de dados!");
            return new ResponseEntity<>(mensagemC.getMensagemGerada(),HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.findByCodigoId(codigoId), HttpStatus.OK);

        }
    }

    public ResponseEntity<List <Aluno>> mostrarLista (){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    @Transactional
    public void deletar(Integer codigoId){
        acao.deleteByCodigoId(codigoId);
    }

    @Transactional
    public void deletarTudo(){
        acao.deleteAll();
        acao.resetAutoIncrement();
    }

    public ResponseEntity<List <Aluno>> listaOrdenadaAZ(){
        return new ResponseEntity<>(acao.findByOrderByNomeAsc(), HttpStatus.OK);
    }

    public ResponseEntity<List <Aluno>> listaOrdenadaZA(){
        return new ResponseEntity<>(acao.findByOrderByNomeDesc(), HttpStatus.OK);
    }

    public ResponseEntity<List <Aluno>> buscaPalavra(String palavra){
        return new ResponseEntity<>(acao.findByNomeContaining(palavra), HttpStatus.OK);
    }
 
    public ResponseEntity<Aluno> substituirObj(Aluno obj){
        return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
    }

    public ResponseEntity<List <Aluno>> buscaInicial(String letraInicial){
        return new ResponseEntity<>(acao.findByNomeStartingWith(letraInicial), HttpStatus.OK);
    }

    public ResponseEntity<List <Aluno>> buscaFinal(String letraFinal){
        return new ResponseEntity<>(acao.findByNomeEndsWith(letraFinal), HttpStatus.OK);
    }
}