/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.mapping.PrimaryKey;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="professores")
@PrimaryKeyJoinColumn(name="professorid")
public class Professor extends Pessoa implements Serializable {
      
    @Column(name="titulacao", length=255)
    private String titulacao;
    
    @Column(name="nivel", length=10)
    private int nivel;
    
    @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="ProfessorDisciplina",  
    joinColumns= @JoinColumn(name="professorid"), 
    inverseJoinColumns=@JoinColumn(name="disciplinaid")
    )
    List<Disciplina> disciplinas;  
    
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
