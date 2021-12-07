package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.FilmeLocadora;

@Repository
@Transactional
public class FilmeLocadoraDAO {
    
    @Autowired
    private EntityManager entityManager;

    public FilmeLocadora insert(FilmeLocadora filmeLocadora) {
        entityManager.persist(filmeLocadora);
        return filmeLocadora;
    }

    public FilmeLocadora getById(int id) {
        FilmeLocadora fl = entityManager.find(FilmeLocadora.class, id);
        return fl;
    }

    public List<FilmeLocadora> getAll(){
        ArrayList<FilmeLocadora> filmeLocadoraList = new ArrayList<FilmeLocadora>();
        String sql = "Select e from " + FilmeLocadora.class.getName() + " e";
        Query query = entityManager.createQuery(sql, FilmeLocadora.class);
        List<FilmeLocadora> flQuery = query.getResultList();
        flQuery.forEach((fl) -> filmeLocadoraList.add((FilmeLocadora)fl));
        return filmeLocadoraList;
    }

    public void delete(int id) {
        FilmeLocadora filmeLocadora = getById(id);
		entityManager.remove(filmeLocadora);
    }
}
