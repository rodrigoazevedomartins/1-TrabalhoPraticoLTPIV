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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="disciplinas")
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long disciplinaid;
    
    @ManyToMany(cascade= CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name="ProfessorDisciplina",
    joinColumns= @JoinColumn(name="disciplinaid"), 
    inverseJoinColumns=@JoinColumn(name="professorid"))
    List<Professor> professores;
    
    @Column(name="nome", length=255)
    private String nome;
    
    @Column(name="ementa", length=255)
    private String ementa;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="cursoid")
    private Curso curso;

    public Long getDisciplinaid() {
        return disciplinaid;
    }

    public void setDisciplinaid(Long disciplinaid) {
        this.disciplinaid = disciplinaid;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public void addProfessor(Professor professor){
        if(!professores.contains(professor)){
            professores.add(professor);
        }
    }
    
    public void removeProfessor(Professor professor){
        if(professores.contains(professor)){
            professores.add(professor);
        }
    }
    
}
