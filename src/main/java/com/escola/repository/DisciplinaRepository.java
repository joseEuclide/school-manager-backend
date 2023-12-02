package com.escola.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.model.Curso;
import com.escola.model.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
    public List<String> findByNivel(String disciplina);
    public Optional<Disciplina> findByNomeAndCurso(String nome,Curso curso);
    public Optional<Disciplina> findByNomeAndCursoAndNivel(String nome,Curso curso,String nivel);
    public Optional<Disciplina> findByNome(String nome);
    public ArrayList<Disciplina> findByCursoAndNivel(Curso curso, String nivel);
}
