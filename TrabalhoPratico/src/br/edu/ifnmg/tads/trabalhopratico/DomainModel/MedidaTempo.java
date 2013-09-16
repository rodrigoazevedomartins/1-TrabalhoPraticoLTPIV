/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="medidastempo")
public class MedidaTempo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long medidatempoid;
    
    @Column(name="nome", length=255)
    private String nome;
    
    @Column(name="ativo", length = 1)
    private int ativo;
    
    public MedidaTempo(String nome, int ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
    
    public MedidaTempo() {
        this.nome = "";
        this.ativo = 1;
    }

    public Long getMedidatempoid() {
        return medidatempoid;
    }

    public void setMedidatempoid(Long medidatempoid) {
        this.medidatempoid = medidatempoid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.medidatempoid);
        hash = 29 * hash + Objects.hashCode(this.nome);
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
        final MedidaTempo other = (MedidaTempo) obj;
        if (!Objects.equals(this.medidatempoid, other.medidatempoid)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
