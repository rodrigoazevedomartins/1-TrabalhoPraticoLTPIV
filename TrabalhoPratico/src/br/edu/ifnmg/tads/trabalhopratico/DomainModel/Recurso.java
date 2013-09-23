/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="recursos")
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recursoid;

    @Column(name="nome", length=255)
    private String nome;
    
    @Column(name="descricao", length=255)
    private String descricao;
    
    @Column(name="capacidade")
    private int capacidade;
    
    @Column(name="num_patrimonio")
    private int num_patrimonio;
    
    @Column(name="tempo")
    private int tempo;
    
    @Column(name="ativo", length = 1)
    private int ativo;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="tiporecursoid")
    private TipoRecurso tiporecurso;
    
    @Column(name="medidatempo", length = 1)
    private int medidatempo;

    public Recurso(String nome, String descricao, int capacidade, int num_patrimonio, int tempo, int ativo, TipoRecurso tiporecurso, int medidatempo) {
        this.nome = nome;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.num_patrimonio = num_patrimonio;
        this.tempo = tempo;
        this.ativo = ativo;
        this.tiporecurso = tiporecurso;
        this.medidatempo = medidatempo;
    }
    
     public Recurso() {
        this.nome = "";
        this.descricao = "";
        this.capacidade = 0;
        this.num_patrimonio = 0;
        this.tempo = 0;
        this.ativo = 1;
        this.tiporecurso = new TipoRecurso();
        this.medidatempo = 0;
    }

    public Long getRecursoid() {
        return recursoid;
    }

    public void setRecursoid(Long recursoid) {
        this.recursoid = recursoid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getNum_patrimonio() {
        return num_patrimonio;
    }

    public void setNum_patrimonio(int num_patrimonio) {
        this.num_patrimonio = num_patrimonio;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    public TipoRecurso getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(TipoRecurso tiporecurso) {
        this.tiporecurso = tiporecurso;
    }
    
    @Transient
    public void setMedidaTempo(int medida){
        this.medidatempo = medida;
        
    }
    
    @Transient
    public int getMedidaTempo(){
        return medidatempo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + this.capacidade;
        hash = 97 * hash + this.num_patrimonio;
        hash = 97 * hash + this.tempo;
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
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if (this.tempo != other.tempo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
     
     
    
}
