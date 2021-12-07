package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Filme;
import entity.FilmeLocadora;

@Repository
@Transactional
public class FilmeDAO {
    
    @Autowired
    private EntityManager entityManager;

    public Filme getById(int id) {
        Filme filme = entityManager.find(Filme.class, id);
        return filme;
    }

    public List<Filme> getAll() {
        ArrayList<Filme> filmeList = new ArrayList<Filme>();
        String sql = "Select e from " + Filme.class.getName() + " e";
        Query query = entityManager.createQuery(sql, Filme.class);
        List<Filme> filmesQuery = query.getResultList();

        for (Filme filme : filmesQuery) {
            String sql1 = "Select ur.locadora.nome, ur.locadora.cidade, ur.locadora.preco_aluguel from "
			+ "filme_locadora ur where ur.filme.id = :filmeId";
				Query query1 = entityManager.createQuery(sql1);
				query1.setParameter("filmeId", filme.getId());
				List<Object> locadoras = query1.getResultList();
				if(locadoras.isEmpty())
					continue;

			filme.setLocadoras(locadoras);
        }

        filmesQuery.forEach((filme) -> filmeList.add((Filme)filme));
        return filmeList;
    }

    public List<Filme> getByDiretor(String diretor) {
        ArrayList<Filme> filmeList = new ArrayList<Filme>();
        String sql = "Select e from " + Filme.class.getName() + " e" //
                + " Where e.diretor = :diretor ";
        Query query = entityManager.createQuery(sql, Filme.class);
        query.setParameter("diretor", diretor);
        List<Filme> filmesQuery = query.getResultList();

        for (Filme filme : filmesQuery) {
            String sql1 = "Select ur.locadora.nome, ur.locadora.cidade, ur.locadora.preco_aluguel from "
			+ "filme_locadora ur where ur.filme.id = :filmeId";
				Query query1 = entityManager.createQuery(sql1);
				query1.setParameter("filmeId", filme.getId());
				List<Object> locadoras = query1.getResultList();
				if(locadoras.isEmpty())
					continue;

			filme.setLocadoras(locadoras);
        }

        filmesQuery.forEach((filme) -> filmeList.add((Filme)filme));
        return filmeList;
    }

    public List<Filme> getByAno(int ano) {
        ArrayList<Filme> filmeList = new ArrayList<Filme>();
        String sql = "Select e from " + Filme.class.getName() + " e " //
                + " Where e.ano = :ano ";
        Query query = entityManager.createQuery(sql, Filme.class);
        query.setParameter("ano", ano);
        List<Filme> filmesQuery = query.getResultList();

        for (Filme filme : filmesQuery) {
            String sql1 = "Select ur.locadora.nome, ur.locadora.cidade, ur.locadora.preco_aluguel from "
			+ "filme_locadora ur where ur.filme.id = :filmeId";
				Query query1 = entityManager.createQuery(sql1);
				query1.setParameter("filmeId", filme.getId());
				List<Object> locadoras = query1.getResultList();
				if(locadoras.isEmpty())
					continue;

			filme.setLocadoras(locadoras);
        }

        filmesQuery.forEach((filme) -> filmeList.add((Filme)filme));
        return filmeList;
    }

    public Filme insert(Filme filme) {
        entityManager.persist(filme);
        return filme;
    }

    public void update(Filme filme) {
        entityManager.merge(filme);
    }

    public void delete(int id) {
        Filme filme = getById(id);
        if (entityManager.contains(filme)) {
            entityManager.remove(filme);
        } else {
            entityManager.remove(entityManager.merge(filme));
        }
    }
}
