/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.TipoRecurso;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class TipoRecursoDAO extends DAOGenerico<TipoRecurso>{

    public TipoRecursoDAO() {
        super(TipoRecurso.class);
    }
    
    public List<TipoRecurso> buscarTiposRecurso(TipoRecurso filtro){
        
        String sql = "select tr from TipoRecurso tr where tr.ativo = 1";
        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if(filtro.getNome().length() > 0){
            sql = sql + " and tr.nome = :tr0";
            parametros.put("tr0", filtro.getNome());
        }
        
        if(filtro.getDescricao().length() > 0){
            sql = sql + " and tr.descricao = :tr1";
            parametros.put("tr1", filtro.getDescricao());
        }
        
        Query consulta = manager.createQuery(sql);
        
        for (String par : parametros.keySet()) {
            consulta.setParameter(par, parametros.get(par));
        }
        
        
        return consulta.getResultList();
    }
    
    public List<TipoRecurso> listarTodos(){
        Query consulta = manager.createQuery("select tr from TipoRecurso tr where tr.ativo = 1");
        return  consulta.getResultList();
    }
    
}
