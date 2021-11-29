package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Locadora", //
        uniqueConstraints = { //
            @UniqueConstraint(name = "LOCADORA_UK", columnNames = "Nome") })
public class Locadora {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Cidade", nullable = false)
    private String cidade;

    @Column(name = "PrecoAluguel", nullable = false)
    private float precoAluguel;

    @Transient
    private List<Object> filmes = new ArrayList<>();

    // getters e setters:
}
