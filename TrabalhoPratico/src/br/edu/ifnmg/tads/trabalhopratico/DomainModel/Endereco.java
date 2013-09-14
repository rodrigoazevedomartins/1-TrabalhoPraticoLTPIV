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
@Table (name="enderecos")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long enderecoid;
    
    @Column(name="rua", length=255)
    private String rua;
    
    @Column(name="numero", length=10)
    private int numero;
    
    @Column(name="complemento", length=255)
    private String complemento;
    
    @Column(name="bairro", length=255)
    private String bairro;
    
    @Column(name="cidade", length=255)
    private String cidade;
    
    @Column(name="estado", length=255)
    private String estado;
    
    @Column(name="cep", length=10)
    private String cep;
        
    @Column(name="pais", length=255)
    private String pais;
    
    @Column(name="ativo", length=1)
    private int ativo;
    
    @ManyToOne(cascade= CascadeType.ALL, fetch= FetchType.EAGER)
    @JoinColumn(name="pessoaid")
    private Pessoa pessoa;

    public Endereco(String rua, int numero, String complemento, String bairro, String cidade, String estado, String cep, String pais, int ativo) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
        this.ativo = ativo;
    }
    
    public Endereco() {
        this.rua = "";
        this.numero = 0;
        this.complemento = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
        this.cep = "";
        this.pais = "";
        this.ativo = 1;
    }
    
    public Long getEnderecoid() {
        return enderecoid;
    }

    public void setEnderecoid(Long enderecoid) {
        this.enderecoid = enderecoid;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
        hash = 89 * hash + Objects.hashCode(this.rua);
        hash = 89 * hash + this.numero;
        hash = 89 * hash + Objects.hashCode(this.complemento);
        hash = 89 * hash + Objects.hashCode(this.bairro);
        hash = 89 * hash + Objects.hashCode(this.cidade);
        hash = 89 * hash + Objects.hashCode(this.estado);
        hash = 89 * hash + Objects.hashCode(this.cep);
        hash = 89 * hash + Objects.hashCode(this.pais);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        return true;
    }
       
    @Override
    public String toString() {
        return this.rua;
    }
    
}
