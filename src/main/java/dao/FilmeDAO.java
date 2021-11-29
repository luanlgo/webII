package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Filme;

@Repository
@Transactional
public class FilmeDAO {
    
    @Autowired
    private EntityManager entityManager;

    public Filme getById(int id) {
        try {
			return null;
			
		}catch (NoResultException n) {
			return null;
		}
    }

    public List<Filme> getAll() {
        return new ArrayList<>();
    }

    public List<Filme> getByDiretor(String diretor) {
        return new ArrayList<>();
    }

    public List<Filme> getByAno(int ano) {
        return new ArrayList<>();
    }

    public Filme insert(Filme filme) {
        return null;
    }

    public void update(Filme filme, int id) {
        // 
    }

    public void delete(int id) {
        //
    }
}
