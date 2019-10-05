package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Avaliacao;
import dev.fujioka.java.avancado.web.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService implements CrudInterface<Avaliacao> {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    
	public AvaliacaoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Avaliacao> findAll() {
		return avaliacaoRepository.findAll();
	}

	@Override
	public Optional<Avaliacao> save(Avaliacao entity) {
		return Optional.ofNullable(avaliacaoRepository.save(entity));
	}

	@Override
	public Optional<Avaliacao> findById(long id) {
		return avaliacaoRepository.findById(id);
	}

	@Override
	public void delete(Avaliacao entity) {
		avaliacaoRepository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		avaliacaoRepository.deleteById(id);
		
	}

	@Override
	public long count() {
		return avaliacaoRepository.count();
	}
	
	public List<Avaliacao> getAvaliacaoByProfessorAndDisciplina(String professor, String disciplina) {
		return avaliacaoRepository.findByProfessorAndDisciplina(professor, disciplina);
	}
	
	public List<Avaliacao> getAvaliacaoByProfessor(String professor) {
		return avaliacaoRepository.findByProfessor(professor);
	}
	
	public List<Avaliacao> getAvaliacaoByDisciplina(String disciplina) {
		return avaliacaoRepository.findByDisciplina(disciplina);
	}

}
