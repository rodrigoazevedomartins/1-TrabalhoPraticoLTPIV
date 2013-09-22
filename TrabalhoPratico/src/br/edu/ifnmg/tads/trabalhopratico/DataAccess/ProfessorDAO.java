/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Professor;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class ProfessorDAO extends DAOGenerico<Professor>{
    
    public ProfessorDAO(){
        super(Professor.class);        
    }
    
    public List<Professor> buscarProfessor(Professor filtro){
              
        String sql = "select p from Professor p where p.ativo = 1";
        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
                
        if(filtro.getNome().length() > 0){
            sql = sql + " and p.nome = :p0";
            parametros.put("p0", filtro.getNome());
        }
        
        if(filtro.getCpf() > 0){
            sql = sql + " and p.cpf = :p1";
            parametros.put("p1", filtro.getCpf());
        }
        
        if(filtro.getRg().length() > 0){
            sql = sql + " and p.rg = :p2";
            parametros.put("p2", filtro.getRg());
        }
        
        if(filtro.getTitulacao().length() > 0){
            sql = sql + " and p.titulacao = :p3";
            parametros.put("p3", filtro.getTitulacao());
        }
              
        if(filtro.getNivel() > 0){
            sql = sql + " and p.nivel = :p4";
            parametros.put("p4", filtro.getNivel());
        }
        
        Query consulta = manager.createQuery(sql);
        
        for (String par : parametros.keySet()) {
            consulta.setParameter(par, parametros.get(par));
        }
        
        
        return consulta.getResultList();
        
    }
    
    public List<Professor> listarTodos(){
        
        Query consulta = manager.createQuery("select p from Professor p where p.ativo = 1");
        return consulta.getResultList();
        
    }
    
    
    
}
