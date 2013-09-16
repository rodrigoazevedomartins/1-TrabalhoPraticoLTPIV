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
@Table(name = "emprestimosreservasrecursos")
public class EmprestimoReservaRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emprestimoreservarecursoid;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "emprestimoreservaid")
    private EmprestimoReserva emprestimoreserva;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "recursoid")
    private Recurso recurso;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataprevdevolucao")
    private Date dataprevdevolucao;     // final previsto para devolucao
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datadevolucao")
    private Date datadevolucao;         // devolucao do recurso 
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "statusrecursoid")
    private StatusRecurso statusrecurso;
    
    @Column(name = "ativo")
    private int ativo;

    public EmprestimoReservaRecurso(EmprestimoReserva emprestimoreserva, Recurso recurso, Date dataprevdevolucao, Date datadevolucao, StatusRecurso statusrecurso, int ativo) {
        this.emprestimoreserva = emprestimoreserva;
        this.recurso = recurso;
        this.dataprevdevolucao = dataprevdevolucao;
        this.datadevolucao = datadevolucao;
        this.statusrecurso = statusrecurso;
        this.ativo = ativo;
    }
    
    public EmprestimoReservaRecurso() {
        this.emprestimoreserva = new EmprestimoReserva();
        this.recurso = new Recurso();
        this.dataprevdevolucao = new Date();
        this.datadevolucao = new Date();
        this.statusrecurso = new StatusRecurso();
        this.ativo = 1;
    }

    public Long getEmprestimoreservarecursoid() {
        return emprestimoreservarecursoid;
    }

    public void setEmprestimoreservarecursoid(Long emprestimoreservarecursoid) {
        this.emprestimoreservarecursoid = emprestimoreservarecursoid;
    }

    public EmprestimoReserva getEmprestimoreserva() {
        return emprestimoreserva;
    }

    public void setEmprestimoreserva(EmprestimoReserva emprestimoreserva) {
        this.emprestimoreserva = emprestimoreserva;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Date getDataprevdevolucao() {
        return dataprevdevolucao;
    }

    public void setDataprevdevolucao(Date dataprevdevolucao) {
        this.dataprevdevolucao = dataprevdevolucao;
    }

    public Date getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(Date datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    public StatusRecurso getStatusrecurso() {
        return statusrecurso;
    }

    public void setStatusrecurso(StatusRecurso statusrecurso) {
        this.statusrecurso = statusrecurso;
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
        final EmprestimoReservaRecurso other = (EmprestimoReservaRecurso) obj;
        if (!Objects.equals(this.emprestimoreserva, other.emprestimoreserva)) {
            return false;
        }
        if (!Objects.equals(this.recurso, other.recurso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return recurso.getNome();
    }
    
    
    
    
}
