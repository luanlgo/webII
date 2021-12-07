package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.FilmeDAO;
import dao.FilmeLocadoraDAO;
import dao.LocadoraDAO;
import entity.Filme;
import entity.FilmeLocadora;
import entity.Locadora;

@RestController
@RequestMapping("/filmeLocadora")
public class FilmeLocadoraController {
    
    @Autowired
	private FilmeDAO filmeDAO;
	
	@Autowired
	private LocadoraDAO locadoraDAO;
	
	@Autowired
	private FilmeLocadoraDAO filmeLocadoraDAO;
	
	
	@PostMapping("/add")
	public FilmeLocadora addFilmeLocadora(@RequestBody FilmeLocadora fl) { 
		Filme filme = filmeDAO.getById(1); 
		Locadora locadora = locadoraDAO.getById(1); 
		FilmeLocadora filmeLocadora = new FilmeLocadora(); 
		filmeLocadora.setFilme(filme); 
		filmeLocadora.setLocadora(locadora);
		return filmeLocadoraDAO.insert(filmeLocadora); 
	}
	 
	@GetMapping("/all")
    public List<FilmeLocadora> getAll() {
        return filmeLocadoraDAO.getAll();
    }
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
	    filmeLocadoraDAO.delete(id);
	}
}
