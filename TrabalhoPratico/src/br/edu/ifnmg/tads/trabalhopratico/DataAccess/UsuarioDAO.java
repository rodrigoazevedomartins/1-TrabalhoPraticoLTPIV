/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Usuario;
import javax.persistence.Query;

/**
 *
 * @author Rodrigo
 */
public class UsuarioDAO extends DAOGenerico<Usuario>{
    
    public UsuarioDAO(){
        super(Usuario.class);
    }
    
    public boolean VerificaUsuario(Usuario filtro){
        
        Query consulta = manager.createQuery("select u from Usuario u where u.ativo = 1 and u.pessoaid = :u1");
        consulta.setParameter("u1", filtro.getPessoaid());
        if (consulta.getResultList() != null){
            return true;            
        } else {
            return false;
        }        
    }
    
    public Usuario Login(Usuario filtro){
        
        Query consulta = manager.createQuery("select u from Usuario u where u.ativo = 1 and (u.login = :u1 and u.senha = u2)");
        consulta.setParameter("u1", filtro.getLogin());
        consulta.setParameter("u2", filtro.getSenha());
        
        
        if (consulta.getSingleResult() != null){
            
            Usuario u = (Usuario) consulta.getSingleResult();
            
            return u;
            
        } else {
            
            return null;
        }
        
    }
}
