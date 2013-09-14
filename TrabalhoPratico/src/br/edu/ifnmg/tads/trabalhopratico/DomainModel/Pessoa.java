/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Rodrigo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name="pessoas")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pessoaid;
    
    @Column(name="nome", length=255)
    private String nome;
    
    @Column(name="rg", length=12)
    private String rg;
    
    @Column(name="cpf", length=11)
    private int cpf;
    
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    
    @Column(name="ativo", length=1)
    private int ativo;
    
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="pessoaid")
    //@IndexColumn(name="enderecoid") 
    List<Endereco> enderecos;
    
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="pessoaid")
    //@IndexColumn(name="emailid") 
    List<Email> emails;
    
    
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="pessoaid")
    //@IndexColumn(name="telefoneid") 
    List<Telefone> telefones; 
    
    public Pessoa(String nome, String rg, int cpf, Date datanasc, int ativo) {
        this.emails = new LinkedList<>();
        this.telefones = new LinkedList<>();
        this.enderecos = new LinkedList<>();
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.ativo = ativo;
    }
    
    public Pessoa() {
        this.emails = new LinkedList<>();
        this.telefones = new LinkedList<>();
        this.enderecos = new LinkedList<>();
        this.nome = "";
        this.rg = "";
        this.cpf = 0;
        this.datanasc = new Date();
        this.ativo = 1;
    }
    
    public Long getPessoaid() {
        return pessoaid;
    }

    public void setPessoaid(Long pessoaid) {
        this.pessoaid = pessoaid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }
    
    public void setAtivo(int ativo){
        this.ativo = ativo;
    }
    
    public int getAtivo(){
        return this.ativo;
    }
    
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }
    
    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    public void addTelefone(Telefone telefone){
        if(!telefones.contains(telefone)){
            telefones.add(telefone);
        }
    }
    
    public void addEmail(Email email){
        if(!emails.contains(email)){
            emails.add(email);
        }
    }
    
    public void addEndereco(Endereco endereco){
        if(!enderecos.contains(endereco)){
            enderecos.add(endereco);
        }
    }
    
    public void removeTelefone(Telefone telefone){
        if(telefones.contains(telefone)){
            telefones.remove(telefone);
        }
    }
    
    public void removeEndereco(Endereco endereco){
        if(enderecos.contains(endereco)){
            enderecos.remove(endereco);
        }
    }
    
    public void removeEmail(Email email){
        if(emails.contains(email)){
            emails.remove(email);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.rg);
        hash = 41 * hash + this.cpf;
        hash = 41 * hash + Objects.hashCode(this.datanasc);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (!Objects.equals(this.datanasc, other.datanasc)) {
            return false;
        }
        return true;
    }
    
        
    @Override
    public String toString() {
        return this.nome;
    }
    
}
