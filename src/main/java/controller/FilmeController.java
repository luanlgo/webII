package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.FilmeDAO;
import entity.Filme;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    
    @Autowired
    private FilmeDAO filmeDAO;

    @GetMapping("/{id}")
	public Filme getFilme(@PathVariable int id) {
		Filme filme = filmeDAO.getById(id);
		return filme == null ? null : filme;
	}

	@GetMapping("/all")
	public List<Filme> getFilmes() {
		return filmeDAO.getAll();
	}

	@GetMapping("/byDiretor/{diretor}")
	public List<Filme> getFilmesByDiretor(@PathVariable String diretor) {
		return filmeDAO.getByDiretor(diretor);
	}

	@GetMapping("/byAno/{ano}")
	public List<Filme> getFilmesByAno(@PathVariable int ano) {
		return filmeDAO.getByAno(ano);
	}

    @PostMapping("/add")
    public Filme addFilme(@RequestBody Filme filme) {
		return filmeDAO.insert(filme);	
	}

    @PutMapping("/update/{id}")
	public void updateFilme(@RequestBody Filme filme, @PathVariable int id) {		
		filmeDAO.update(filme);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteFilme(@PathVariable int id) {
		filmeDAO.delete(id);
	}
}
