package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

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
        return null;
    }

    public List<Locadora> getAll() {
        return new ArrayList<>();
    }

    public List<Locadora> getByCidade(String cidade) {
        return new ArrayList<>();
    }

    public List<Locadora> getByPreco(float preco) {
        return new ArrayList<>();
    }

    public Locadora insert(Locadora locadora) {
        return null;
    }

    public void update(Locadora locadora, int id) {
        // 
    }

    public void delete(int id) {
        //
    }
}
