package dev.fujioka.java.avancado.web.web.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.java.avancado.web.domain.Avaliacao;
import dev.fujioka.java.avancado.web.service.AvaliacaoService;

@RestController
@RequestMapping("/api")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService avaliacaoService;

	@GetMapping("/avaliacao/listar")
	public List<Avaliacao> getAvaliacoes() {
		return avaliacaoService.findAll();
	}

	@GetMapping("/avaliacao/{id}")
    public ResponseEntity<Avaliacao> getAvaliacaoById(@PathVariable Long id, 
    		@RequestParam(name = "disciplina", 
    		defaultValue = "java",
    		required = false) String disciplina) {
		Optional<Avaliacao> retorno = avaliacaoService.findById(id);
		
		if(retorno.isPresent()) {
			return ResponseEntity.of(retorno);
		}
		return ResponseEntity.notFound().build();
    }

    @PostMapping("/avaliacao")
    public Avaliacao save(@Valid @RequestBody Avaliacao avaliacao) {
    	return avaliacaoService.save(avaliacao).get();
    }

	@GetMapping("/avaliacao/{professor}/{disciplina}")
    public List<Avaliacao> getAvaliacaoByProfessorAndDisciplina(@PathVariable String professor, @PathVariable String disciplina) {
		return avaliacaoService.getAvaliacaoByProfessorAndDisciplina(professor, disciplina);
    }

	@GetMapping("/avaliacao/professor/{professor}")
    public List<Avaliacao> getAvaliacaoByProfessor(@PathVariable String professor) {
		return avaliacaoService.getAvaliacaoByProfessor(professor);
    }

	@GetMapping("/avaliacao/disciplina/{disciplina}")
    public List<Avaliacao> getAvaliacaoByDisciplina(@PathVariable String disciplina) {
		return avaliacaoService.getAvaliacaoByDisciplina(disciplina);
    }

}
