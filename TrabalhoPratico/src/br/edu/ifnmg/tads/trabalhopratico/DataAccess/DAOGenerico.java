/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhopratico.DataAccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Rodrigo
 */
public abstract class DAOGenerico<T> {
    
    protected EntityManager manager;
    private EntityManagerFactory factory;
    private Class tipo;
    
    public DAOGenerico(Class t){
        
        factory = Persistence.createEntityManagerFactory("TrabalhoPraticoPU");
        manager = factory.createEntityManager();
        tipo = t;
        
    }
    
    
    public boolean Salvar(T obj){
        
        EntityTransaction transaction = manager.getTransaction();
        
        try{
            transaction.begin();
            
            manager.persist(obj);
            
            transaction.commit();
            
            return true;
        
        } catch(Exception ex){
            
            transaction.rollback();
            return false;
        
        }
            
    }
    
    public T Abrir(long id){
        
        EntityTransaction transaction = manager.getTransaction();
        
        try{
            
            T obj = (T)manager.find(tipo, id); 
            
            return obj;
            
        } catch(Exception ex){
            
            return null;
      
        }
        
    }
    
    public boolean Excluir(T obj){
        
        EntityTransaction transaction = manager.getTransaction();
        
        try{
            
            transaction.begin();
            
            manager.merge(obj);
            
            transaction.commit();
            
            return true;
            
        } catch(Exception ex){
            
            transaction.rollback();
            
            return false;
        }
           
    }
    
}
