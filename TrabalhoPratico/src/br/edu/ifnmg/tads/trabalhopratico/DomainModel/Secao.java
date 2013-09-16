/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="secoes")
public class Secao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long secaoid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="iniciosecao")
    private Date iniciosecao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="finalsecao")
    private Date finalsecao;
    
    @Column(name="ativo", length=1)
    private int ativo;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="usuarioid")
    private Usuario usuario;

    public Secao(Date iniciosecao, Date finalsecao, int ativo, Usuario usuario) {
        this.iniciosecao = iniciosecao;
        this.finalsecao = finalsecao;
        this.ativo = ativo;
        this.usuario = usuario;
    }

     public Secao() {
        this.iniciosecao = new Date();
        this.finalsecao = new Date();
        this.ativo = 1;
        this.usuario = new Usuario();
    }
    
    public Long getSecaoid() {
        return secaoid;
    }

    public void setSecaoid(Long secaoid) {
        this.secaoid = secaoid;
    }

    public Date getIniciosecao() {
        return iniciosecao;
    }

    public void setIniciosecao(Date iniciosecao) {
        this.iniciosecao = iniciosecao;
    }

    public Date getFinalsecao() {
        return finalsecao;
    }

    public void setFinalsecao(Date finalsecao) {
        this.finalsecao = finalsecao;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
       
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.iniciosecao);
        hash = 79 * hash + Objects.hashCode(this.finalsecao);
        hash = 79 * hash + Objects.hashCode(this.usuario);
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
        final Secao other = (Secao) obj;
        if (!Objects.equals(this.iniciosecao, other.iniciosecao)) {
            return false;
        }
        if (!Objects.equals(this.finalsecao, other.finalsecao)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+this.iniciosecao;
    }
    
    
    
    
}
