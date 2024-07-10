package com.alunos.Sala.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alunos.Sala.Model.Aluno;

import jakarta.transaction.Transactional;

@Repository
public interface Repositorio extends CrudRepository<Aluno, Integer> {
    List<Aluno> findByCodigoId(Integer codigoId);

    @Override
    List<Aluno> findAll();

    void deleteByCodigoId(Integer codigoId);
    @Override
    void deleteAll();

    @Modifying
    @Transactional
    @Query(value = "ALTER TABLE alunos AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();

    List<Aluno> findByOrderByNomeAsc();

    List<Aluno> findByOrderByNomeDesc();

    List<Aluno> findByNomeContaining(String palavra);

    List <Aluno> findByNomeStartingWith(String palavra);

    List<Aluno> findByNomeEndsWith(String palavra);
}
