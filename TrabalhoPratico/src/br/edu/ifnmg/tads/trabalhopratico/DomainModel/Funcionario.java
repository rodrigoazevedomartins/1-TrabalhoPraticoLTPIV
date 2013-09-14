/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DomainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="funcionarios")
@PrimaryKeyJoinColumn(name = "funcionarioid")
public class Funcionario extends Pessoa implements Serializable {
     
    @Column(name="cargo")
    private String cargo;
    
    @Column(name="siape")
    private String siape;

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
    
    
    
}
