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

/**
 *
 * @author Rodrigo
 */
@Entity
@Table (name="emails")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailid;

    @Column(name="email", length=255)
    private String email;
    
    @Column(name="ativo", length=1)
    private int ativo;
    
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name="pessoaid")
    private Pessoa pessoa;
    
    public Email(String email, int ativo) {
        this.email = email;
        this.ativo = ativo;
    }
    
    public Email() {
        this.email = "";
        this.ativo = 1;
    }

    public Long getEmailid() {
        return emailid;
    }

    public void setEmailid(Long emailid) {
        this.emailid = emailid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash = 29 * hash + Objects.hashCode(this.email);
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
        final Email other = (Email) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.email;
    }
    
    
}
