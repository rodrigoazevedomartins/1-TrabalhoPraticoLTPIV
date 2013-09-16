/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="professores")
public class Professor extends Pessoa implements Serializable {
      
    @Column(name="titulacao", length=255)
    private String titulacao;
    
    @Column(name="nivel", length=10)
    private int nivel;
    
    @Column(name="ativo", length=1)
    private int ativo;
    
    @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="professordisciplina",  
    joinColumns= @JoinColumn(name="professorid"), 
    inverseJoinColumns=@JoinColumn(name="disciplinaid")
    )
    List<Disciplina> disciplinas;

    public Professor(String titulacao, int nivel, int ativo, List<Disciplina> disciplinas) {
        this.titulacao = titulacao;
        this.nivel = nivel;
        this.disciplinas = disciplinas;
        this.ativo = ativo;
    }
    
    public Professor() {
        this.titulacao = "";
        this.nivel = 0;
        this.ativo = 1;
        this.disciplinas = new LinkedList<>();
    }
        
    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
       
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    public void addDisciplina(Disciplina disciplina){
        if(!disciplinas.contains(disciplina)){
            disciplinas.add(disciplina);
        }
    }
    
    public void removeDisciplina(Disciplina disciplina){
        if(disciplinas.contains(disciplina)){
            disciplinas.remove(disciplina);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.titulacao);
        hash = 73 * hash + this.nivel;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
    
    
    

    
}
