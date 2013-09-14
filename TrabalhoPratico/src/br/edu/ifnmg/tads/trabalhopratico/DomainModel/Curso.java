/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="cursos")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cursoid;
    
    @Column(name="nome", length=255)
    private String nome;
    
    @Column(name="duracao", length=2)
    private int duracao;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cursoid")
    private List<Disciplina> disciplinas;

    public Curso(String nome, int duracao, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.duracao = duracao;
        this.disciplinas = disciplinas;
    }

    public Curso() {
        this.nome = "";
        this.duracao = 0;
        this.disciplinas = new LinkedList<>();
    }
    
    public Long getCursoid() {
        return cursoid;
    }

    public void setCursoid(Long cursoid) {
        this.cursoid = cursoid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public void addDisciplinas(Disciplina disciplina){
        if(!disciplinas.contains(disciplina)){
            disciplinas.add(disciplina);
        }
    }
    
    public void removeDisciplinas(Disciplina disciplina){
        if(disciplinas.contains(disciplina)){
            disciplinas.remove(disciplina);
        }
    }
    
    
    
}
