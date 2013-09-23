/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Recurso;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class RecursoDAO extends DAOGenerico<Recurso>{
    
    public RecursoDAO(){
        super(Recurso.class);
    }
    
    public List<Recurso> buscarRecurso(Recurso filtro){
        
        String sql = "select r from Recurso r where r.ativo = 1";
        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if(filtro.getNome().length() > 0){
            sql = sql + " and r.nome = :r0";
            parametros.put("r0", filtro.getNome());
        }
        
        if(filtro.getNum_patrimonio() > 0){
            sql = sql + " and r.num_patrimonio = :r1";
            parametros.put("r1", filtro.getNum_patrimonio());
        }
        
        if(filtro.getDescricao().length() > 0){
            sql = sql + " and r.descricao = :r2";
            parametros.put("r2", filtro.getDescricao());
        }
        
        if(filtro.getTempo() > 0){
            sql = sql + " and r.tempo = :r3 and r.medidatempo  = :r4";
            parametros.put("r3", filtro.getTempo());
            parametros.put("r4", filtro.getMedidaTempo());
        }
        
        if(filtro.getCapacidade() > 0){
            sql = sql + " and r.capacidade = :r5";
            parametros.put("r5", filtro.getCapacidade());
        }
        
        Query consulta = manager.createQuery(sql);
        
        for (String par : parametros.keySet()) {
            consulta.setParameter(par, parametros.get(par));
        }
        
        
        return consulta.getResultList();
    }
    
    public List<Recurso> listarTodos(){
        
        Query consulta = consulta = manager.createQuery("select r from Recurso r where r.ativo = 1");
        return consulta.getResultList();
        
    }
    
}
    