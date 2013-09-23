/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Secao;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class SecaoDAO extends DAOGenerico<Secao>{
    
    public SecaoDAO(){
        super(Secao.class);
    }
    
    
    public List<Secao> listarTodos(Usuario filtro){
        
        Query consulta = manager.createQuery("select s from Secao s where s.ativo = 1 and s.usuario.pessoaid = :s1");
        
        consulta.setParameter("s1", filtro.getPessoaid());
        
        return consulta.getResultList();
        
    }
    
}
