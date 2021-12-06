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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public float getPrecoAluguel(){
        return precoAluguel;
    }

    public void setPrecoAluguel(float precoAluguel){
        this.precoAluguel = precoAluguel;
    }
}
