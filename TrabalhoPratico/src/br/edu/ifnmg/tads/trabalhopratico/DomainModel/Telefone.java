/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
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

/**
 *
 * @author Rodrigo
 */
@Entity
@Table (name="telefones")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long telefoneid;
    
    @Column(name="areaddd", length=2)
    private int areaddd;
    
    @Column(name="numero", length=8)
    private int numero;
    
    @Column(name="ativo", length=1)
    private int ativo;
    
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name="pessoaid")
    private Pessoa pessoa;

    public Telefone(int areaddd, int numero, int ativo) {
        this.areaddd = areaddd;
        this.numero = numero;
        this.ativo = ativo;
    }
    
    public Telefone() {
        this.areaddd = 0;
        this.numero = 0;
        this.ativo = 1;
    }

    public Long getTelefoneid() {
        return telefoneid;
    }

    public void setTelefoneid(Long telefoneid) {
        this.telefoneid = telefoneid;
    }

    public int getAreaddd() {
        return areaddd;
    }

    public void setAreaddd(int areaddd) {
        this.areaddd = areaddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.areaddd;
        hash = 47 * hash + this.numero;
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
        final Telefone other = (Telefone) obj;
        if (this.areaddd != other.areaddd) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+this.numero;
    }
 
}
