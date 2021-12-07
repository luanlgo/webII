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

import dao.LocadoraDAO;
import entity.Locadora;

@RestController
@RequestMapping("/locadoras")
public class LocadoraController {
    
    @Autowired
    private LocadoraDAO locadoraDAO;

    @GetMapping("/{id}")
	public Locadora getLocadora(@PathVariable int id) {
		Locadora locadora = locadoraDAO.getById(id);
        return locadora == null ? null : locadora;
	}

	@GetMapping("/all")
	public List<Locadora> getAll() {
		return locadoraDAO.getAll();
	}

	@GetMapping("/getByCidade/{cidade}")
	public List<Locadora> getByCidade(@PathVariable String cidade) {
		return locadoraDAO.getByCidade(cidade);
	}

	@GetMapping("/getByPreco/{preco}")
	public List<Locadora> getByPreco(@PathVariable float preco) {
		return locadoraDAO.getByPreco(preco);
	}

    @PostMapping("/add")
    public Locadora addLocadora(@RequestBody Locadora locadora) {
		return locadoraDAO.insert(locadora);	
	}

    @PutMapping("/update/{id}")
	public void updateLocadora(@RequestBody Locadora locadora, @PathVariable int id) {		
		locadoraDAO.update(locadora);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLocadora(@PathVariable int id) {
		locadoraDAO.delete(id);
	}
}
