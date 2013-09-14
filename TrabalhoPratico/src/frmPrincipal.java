
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Email;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Endereco;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Funcionario;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Pessoa;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Professor;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Telefone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class frmPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManager manager;
        EntityManagerFactory factory;
        
        factory = Persistence.createEntityManagerFactory("TrabalhoPraticoPU");
        manager = factory.createEntityManager();
        
        EntityTransaction transacao = manager.getTransaction();
        
        
        try{
            
            transacao.begin();
            
            Funcionario func = new Funcionario();
            
            Professor pf = new Professor();
            
            Email em = new Email();
            Telefone tel = new Telefone();
            
            em.setEmail("rodrigomartins.tads@gmail.com");
            
            //func.setCargo("administrador");
            pf.setNome("Rodrigo");
            
                      
            tel.setAreaddd(38);
            tel.setNumero(91603909);
            pf.addEmail(em);
            
            em.setPessoa(pf);
            
            tel.setPessoa(pf);
            
            pf.addTelefone(tel);
            
            tel = new Telefone();
            
            tel.setAreaddd(33);
            tel.setNumero(91603909);
            
            tel.setPessoa(pf);
            
            pf.addTelefone(tel);
            
            manager.persist(em);
            
            for(Telefone te : pf.getTelefones()){
                
                   manager.persist(te);
            
            }
            
            manager.persist(pf);
            
            
            transacao.commit();
        } catch(Exception ex){
            transacao.rollback();
        }
        
        try{
            
            Query consulta = manager.createQuery("select p from Pessoa p");
            
            List<Pessoa> pessoas = consulta.getResultList();
            
            for (Pessoa p : pessoas){
                System.out.println(p.getNome());
            }
            
        } finally {
            manager.close();
        }
             
        
    }
}
