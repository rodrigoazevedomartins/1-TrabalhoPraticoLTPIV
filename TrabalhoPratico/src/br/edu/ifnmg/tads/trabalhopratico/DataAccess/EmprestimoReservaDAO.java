/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.EmprestimoReserva;
import java.util.HashMap;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class EmprestimoReservaDAO extends DAOGenerico<EmprestimoReserva>{
    
    public EmprestimoReservaDAO(){
        super(EmprestimoReserva.class);
    }
    
    public List<EmprestimoReserva> buscarEmprestimoReserva(EmprestimoReserva filtro){
        
        String sql = "select er from EmprestimoReserva er where er.ativo = 1";
        
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        
        if(filtro.getOperacao() > 0){
            sql = sql + " and er.operacao = :er1";
            parametros.put("er1", filtro.getOperacao());
        }
        
        if(filtro.getPessoa().getNome().length() > 0){
            sql = sql + " and er.pessoa.nome = :er2";
            parametros.put("er2", filtro.getPessoa().getNome());
        }
        
        Query consulta = manager.createQuery(sql);
        
        for (String par : parametros.keySet()) {
            consulta.setParameter(par, parametros.get(par));
        }
        
        return consulta.getResultList();
        
    }
    
    public List<EmprestimoReserva> listarTodos(){
        
        Query consulta = manager.createQuery("select er from EmprestimoReserva er where er.ativo = 1");
        return consulta.getResultList();
        
    }
    
}
