/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="funcionarios")
public class Funcionario extends Pessoa implements Serializable {
     
    @Column(name="cargo", length=255)
    private String cargo;
    
    @Column(name="siape", length=255)
    private String siape;
    
    @Column(name="ativo", length=1)
    private int ativo;

    public Funcionario(String cargo, String siape, int ativo) {
        this.cargo = cargo;
        this.siape = siape;
        this.ativo = ativo;
    }
    
    public Funcionario() {
        this.cargo = "";
        this.siape = "";
        this.ativo = 1;
    }
    
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.cargo);
        hash = 89 * hash + Objects.hashCode(this.siape);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.siape, other.siape)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

}
