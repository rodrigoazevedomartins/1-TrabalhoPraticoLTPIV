/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Funcionario;
import java.util.HashMap;
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
        
        String sql = "select f from Funcionario f where f.ativo = 1";
        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
             
        if(filtro.getNome().length() > 0){
            sql = sql + " and f.nome = :f0";
            parametros.put("f0", filtro.getNome());
        }
        
        if(filtro.getCpf() > 0){
            sql = sql + " and f.cpf = :f1";
            parametros.put("f1", filtro.getCpf());
        }
        
        if(filtro.getRg().length() > 0){
            sql = sql + " and f.rg = :f2";
            parametros.put("f2", filtro.getRg());
        }
        
        if(filtro.getSiape().length() > 0){
            sql = sql + " and f.siape = :f3";
            parametros.put("f3", filtro.getSiape());
        }
        
        if(filtro.getCargo().length() > 0){
            sql = sql + " and f.cargo = :f4";
            parametros.put("f4", filtro.getCargo());
        }
        
        Query consulta = manager.createQuery(sql);
        
        for (String par : parametros.keySet()) {
            consulta.setParameter(par, parametros.get(par));
        }
        
        
        return consulta.getResultList();
        
    }
    
    public List<Funcionario> listarTodos(){
        
        Query consulta = manager.createQuery("select f from Funcionario f where f.ativo = 1");
        
        return consulta.getResultList();
        
    }
    
    
    
}
