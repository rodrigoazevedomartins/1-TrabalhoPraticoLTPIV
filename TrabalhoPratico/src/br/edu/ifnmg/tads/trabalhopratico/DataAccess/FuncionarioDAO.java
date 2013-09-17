/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Funcionario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class FuncionarioDAO extends DAOGenerico<Funcionario>{
    
    public FuncionarioDAO(){
        super(Funcionario.class);
    }
    
    public List<Funcionario> buscarFuncionario(Funcionario filtro){
        
        Query consulta = null;
             
        if(filtro.getNome().length() > 0){
            consulta = manager
                    .createQuery("select f from Funcionario f where nome = :p0");
            consulta.setParameter("p0", filtro.getNome());
        }
        
        if(filtro.getCpf() > 0){
            consulta = manager.createQuery("select f from Funcionario f where cpf = :p1");
            consulta.setParameter("p1", filtro.getCpf());
        }
        
        if(filtro.getRg().length() > 0){
            consulta = manager.createQuery("select f from Funcionario f where rg = :p3");
            consulta.setParameter("p3", filtro.getRg());
        }
        
        if(filtro.getCargo().length() > 0){
            consulta = manager.createQuery("select f from Funcionario f where cargo = :p2");
            consulta.setParameter("p2", filtro.getCargo());
        }
        
        return consulta.getResultList();
        
    }
    
    public List<Funcionario> listarTodos(){
        
        Query consulta = manager.createQuery("select f from Funcionario f");
        
        return consulta.getResultList();
        
    }
    
    
    
}
