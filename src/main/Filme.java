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
@Table(name = "Filme", //
        uniqueConstraints = { //
            @UniqueConstraint(name = "FILME_UK", columnNames = "Nome") })
public class Filme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private int id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Ano", nullable = false)
    private int ano;

    @Column(name = "Genero", nullable = false)
    private String genero;

    @Column(name = "Diretor", nullable = false)
    private String diretor;

    @Transient
    private List<Object> locadoras = new ArrayList<>();

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

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getDiretor(){
        return diretor;
    }

    public void setDiretor(String diretor){
        this.diretor = diretor;
    }
}
