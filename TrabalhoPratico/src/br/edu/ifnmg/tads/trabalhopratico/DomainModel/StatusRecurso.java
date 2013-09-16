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

/**
 *
 * @author Rodrigo
 */
@Entity
public class StatusRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusrecursoid;
    
    @Column(name="nomestatus", length=255)
    private String nomestatus;
    
    @Column(name="ativo", length = 1)
    private int ativo;
    
    public StatusRecurso(String nomestatus, int ativo) {
        this.nomestatus = nomestatus;
        this.ativo = ativo;
    }
    
    public StatusRecurso() {
        this.nomestatus = "";
        this.ativo = 1;
    }

    public Long getStatusrecursoid() {
        return statusrecursoid;
    }

    public void setStatusrecursoid(Long statusrecursoid) {
        this.statusrecursoid = statusrecursoid;
    }

    public String getNomestatus() {
        return nomestatus;
    }

    public void setNomestatus(String nomestatus) {
        this.nomestatus = nomestatus;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nomestatus);
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
        final StatusRecurso other = (StatusRecurso) obj;
        if (!Objects.equals(this.nomestatus, other.nomestatus)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.nomestatus;
    }
    
    
    
}
