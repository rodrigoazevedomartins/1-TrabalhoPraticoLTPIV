/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Curso;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class CursoDAO extends DAOGenerico<Curso>{
    
    public CursoDAO(){
        super(Curso.class);
    }
    
    
    public List<Curso> buscarCurso(Curso filtro){
        
        String sql = "select c from Curso c where c.ativo = 1";
        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if(filtro.getNome().length() > 0){
            sql = sql + " and c.nome = :c0";
            parametros.put("c0", filtro.getNome());
        }
        
        if(filtro.getDuracao() > 0){
            sql = sql + " and c.duracao = :c1";
            parametros.put("c1", filtro.getDuracao());
        }
        
        Query consulta = manager.createQuery(sql);
        
        for (String par : parametros.keySet()) {
            consulta.setParameter(par, parametros.get(par));
        }
       
        return consulta.getResultList();
        
    }
    
    public List<Curso> listarTodos(){
        
        Query consulta = manager.createQuery("select c from Curso c where c.ativo = 1");
        return consulta.getResultList();
        
    }
}
