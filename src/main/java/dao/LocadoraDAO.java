package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Locadora;

@Repository
@Transactional
public class LocadoraDAO {

    @Autowired
    private EntityManager entityManager;

    public Locadora getById(int id) {
        Locadora locadora = entityManager.find(Locadora.class, id);
        return locadora;
    }

    public List<Locadora> getAll() {
        ArrayList<Locadora> list = new ArrayList<Locadora>();
        String sql = "Select e from " + Locadora.class.getName() + " e";
        Query query = entityManager.createQuery(sql, Locadora.class);
        List<Locadora> lQuery = query.getResultList();

        for (Locadora loc : lQuery) {
            String sql1 = "Select ur.filme.nome, ur.filme.diretor, ur.filme.ano from "
            +"filme_locadora ur where ur.locadora.id = :locadoraId";
            Query query1 = entityManager.createQuery(sql1);
            query1.setParameter("locadoraId", loc.getId());
            List<Object> filmes = query1.getResultList();
            if(filmes.isEmpty())
                continue;
            loc.setFilmes(filmes);
        }

        lQuery.forEach((locadora) -> list.add((Locadora)locadora));
        return list;
    }

    public List<Locadora> getByCidade(String cidade) {
        ArrayList<Locadora> list = new ArrayList<Locadora>();
        String sql = "Select e from " + Locadora.class.getName() + " e" //
                + " Where e.cidade = :cidade ";
        Query query = entityManager.createQuery(sql, Locadora.class);
        query.setParameter("cidade", cidade);
        List<Locadora> lQuery = query.getResultList();

        for (Locadora loc : lQuery) {
            String sql1 = "Select ur.filme.nome, ur.filme.diretor, ur.filme.ano from "
            +"filme_locadora ur where ur.locadora.id = :locadoraId";
            Query query1 = entityManager.createQuery(sql1);
            query1.setParameter("locadoraId", loc.getId());
            List<Object> filmes = query1.getResultList();
            if(filmes.isEmpty())
                continue;
            loc.setFilmes(filmes);
        }

        lQuery.forEach((locadora) -> list.add((Locadora)locadora));
        return list;
    }

    public List<Locadora> getByPreco(float preco) {
        ArrayList<Locadora> list = new ArrayList<Locadora>();
        String sql = "Select e from " + Locadora.class.getName() + " e " //
                + " Where e.preco_aluguel = :preco ";
        Query query = entityManager.createQuery(sql, Locadora.class);
        query.setParameter("preco", preco);
        List<Locadora> lQuery = query.getResultList();

        for (Locadora loc : lQuery) {
            String sql1 = "Select ur.filme.nome, ur.filme.diretor, ur.filme.ano from "
            +"filme_locadora ur where ur.locadora.id = :locadoraId";
            Query query1 = entityManager.createQuery(sql1);
            query1.setParameter("locadoraId", loc.getId());
            List<Object> filmes = query1.getResultList();
            if(filmes.isEmpty())
                continue;
            loc.setFilmes(filmes);
        }

        lQuery.forEach((locadora) -> list.add((Locadora)locadora));
        return list;
    }

    public Locadora insert(Locadora locadora) {
        entityManager.persist(locadora);
        return locadora;
    }

    public void update(Locadora locadora) {
        entityManager.merge(locadora);
    }
    
    public void delete(int id) {
        Locadora locadora = getById(id);
        if (entityManager.contains(locadora)) {
            entityManager.remove(locadora);
        } else {
            entityManager.remove(entityManager.merge(locadora));
        }
    }
}
