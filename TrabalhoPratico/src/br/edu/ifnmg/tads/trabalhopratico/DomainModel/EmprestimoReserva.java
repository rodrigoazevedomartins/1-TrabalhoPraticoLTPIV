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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="emprestimosreservas")
public class EmprestimoReserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emprestimoreservaid;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dataprevemprestimo")
    private Date dataprevemprestimo;        // previsao do emprestimo
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="datareserva")
    private Date datareserva;          // realizacao da reserva
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dataemprestimo")
    private Date dataemprestimo;        // realizacao do emprestimo 
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="operacaoid")
    private Operacao operacao;          // emprestimo ou reserva
    
    @Column(name = "ativo", length = 1)
    private int ativo;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "secaoid")
    private Secao secao;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaid")
    private Pessoa pessoa;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="emprestimosreservasrecursos",  
    joinColumns= @JoinColumn(name="emprestimoreservaid"), 
    inverseJoinColumns=@JoinColumn(name="recursoid")
    )
    private List<Recurso> recursos;

    public EmprestimoReserva(Date dataprevemprestimo, Date datareserva, Date dataemprestimo, Operacao operacao, int ativo, Secao secao, Pessoa pessoa, List<Recurso> recursos) {
        this.dataprevemprestimo = dataprevemprestimo;
        this.datareserva = datareserva;
        this.dataemprestimo = dataemprestimo;
        this.operacao = operacao;
        this.ativo = ativo;
        this.secao = secao;
        this.pessoa = pessoa;
        this.recursos = recursos;
    }
    
    public EmprestimoReserva() {
        this.dataprevemprestimo = new Date();
        this.datareserva = new Date();
        this.dataemprestimo = new Date();
        this.operacao = new Operacao();
        this.ativo = 1;
        this.secao = new Secao();
        this.pessoa = new Pessoa();
        this.recursos = new LinkedList<>();
    }
    
    
    
    public Long getEmprestimoreservaid() {
        return emprestimoreservaid;
    }

    public void setEmprestimoreservaid(Long emprestimoreservaid) {
        this.emprestimoreservaid = emprestimoreservaid;
    }

    public Date getDataprevemprestimo() {
        return dataprevemprestimo;
    }

    public void setDataprevemprestimo(Date dataprevemprestimo) {
        this.dataprevemprestimo = dataprevemprestimo;
    }

    public Date getDatareserva() {
        return datareserva;
    }

    public void setDatareserva(Date datareserva) {
        this.datareserva = datareserva;
    }

    public Date getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Date dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
    
    public void addRecurso(Recurso recurso){
        if(!recursos.contains(recurso)){
            recursos.add(recurso);
        }
    }
    
    public void removeRecurso(Recurso recurso){
        if(recursos.contains(recurso)){
            recursos.remove(recurso);
        }
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.emprestimoreservaid);
        hash = 89 * hash + Objects.hashCode(this.operacao);
        hash = 89 * hash + Objects.hashCode(this.secao);
        hash = 89 * hash + Objects.hashCode(this.pessoa);
        hash = 89 * hash + Objects.hashCode(this.recursos);
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
        final EmprestimoReserva other = (EmprestimoReserva) obj;
        if (!Objects.equals(this.emprestimoreservaid, other.emprestimoreservaid)) {
            return false;
        }
        if (!Objects.equals(this.operacao, other.operacao)) {
            return false;
        }
        if (!Objects.equals(this.secao, other.secao)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.recursos, other.recursos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+this.emprestimoreservaid;
    }
    
    
    
}
