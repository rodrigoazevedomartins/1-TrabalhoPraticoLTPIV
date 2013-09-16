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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="usuarios")
public class Usuario extends Funcionario implements Serializable {
    
    @Column(name="login", length=255)
    private String login;
    
    @Column(name="senha", length=255)
    private String senha;
    
    @Column(name="ativo", length = 1)
    private int ativo;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="usuarioid")
    private List<Secao> secoes;

    public Usuario(String login, String senha, int ativo,  List<Secao> secoes) {
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.secoes = secoes;
    }
    
    public Usuario() {
        this.login = "";
        this.senha = "";
        this.ativo = 1;
        this.secoes = new LinkedList<>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
       
    public List<Secao> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<Secao> secoes) {
        this.secoes = secoes;
    }
    
    public void addSecao(Secao secao){
        if (!secoes.contains(secao)){
            secoes.add(secao);
        }
    }
    
    public void removeSecao(Secao secao){
        if(secoes.contains(secao)){
            secoes.remove(secao);
        }
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.login);
        hash = 79 * hash + Objects.hashCode(this.senha);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    } 
    
}
