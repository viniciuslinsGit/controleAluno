package dev.fujioka.java.avancado.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.java.avancado.web.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

	public List<Avaliacao> findByProfessor(String professor);
	public List<Avaliacao> findByDisciplina(String disciplina);
	public List<Avaliacao> findByProfessorAndDisciplina(String professor, String disciplina);
}
