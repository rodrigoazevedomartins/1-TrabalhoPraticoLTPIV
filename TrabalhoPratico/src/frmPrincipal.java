
import br.edu.ifnmg.tads.trabalhopratico.DataAccess.CursoDAO;
import br.edu.ifnmg.tads.trabalhopratico.DataAccess.FuncionarioDAO;
import br.edu.ifnmg.tads.trabalhopratico.DataAccess.ProfessorDAO;
import br.edu.ifnmg.tads.trabalhopratico.DataAccess.RecursoDAO;
import br.edu.ifnmg.tads.trabalhopratico.DataAccess.TipoRecursoDAO;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Curso;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Disciplina;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Email;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.EmprestimoReserva;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.EmprestimoReservaRecurso;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Endereco;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Funcionario;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.MedidaTempo;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Pessoa;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Professor;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Recurso;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.StatusRecurso;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.Telefone;
import br.edu.ifnmg.tads.trabalhopratico.DomainModel.TipoRecurso;
import java.util.LinkedList;
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
            
            /*Funcionario func = new Funcionario();
            
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
            
            
            
            Curso curso = new Curso();
            
            curso.setNome("TADS");
            
            Professor pf = new Professor();
            Disciplina disciplina = new Disciplina();
            
            pf.setNome("Rodrigo Azevedo Martins");
            pf.setNivel(1111111);
            
            disciplina.setNome("LTPIII");
            disciplina.setCurso(curso);
            pf.addDisciplina(disciplina);
            disciplina = new Disciplina();
            disciplina.setNome("LTPII");
            disciplina.setCurso(curso);
            pf.addDisciplina(disciplina);
            
            manager.persist(pf);
            
            for (Disciplina d : pf.getDisciplinas()){
                manager.persist(d);
            }
            
            
            
            
            
            Professor p = new Professor();
            Email em = new Email();
            ProfessorDAO pdao = new ProfessorDAO();
            
            em.setEmail("rodrigomartins.tads@gmail.com");
            em.setPessoa(p);
            p.addEmail(em);
            p.setNome("Rodrigo Martins");
            
            
            pdao.Salvar(p);
            */
            
            
          
            transacao.commit();
        } catch(Exception ex){
            transacao.rollback();
        }
        
      
          
            
            /*
            Curso c = new Curso();
            Disciplina d = new Disciplina();
            
            c.setNome("TADS");
            
            d.setNome("LTPIV");
            d.setEmenta("Banco de dados MySQL");
            d.setCurso(c);
            c.addDisciplina(d);
            
            d = new Disciplina();
            
            d.setNome("BDII");
            d.setEmenta("Banco de dados NOSQL");
            d.setCurso(c);
            c.addDisciplina(d);
            
            CursoDAO cdao = new CursoDAO();
            
            cdao.Salvar(c);
            */
            
            ProfessorDAO pfdao = new ProfessorDAO();
            Professor pf = new Professor();
            pf = pfdao.Abrir(1);
            pf.setAtivo(0);
            pfdao.equals(pf);
            
            for(Professor p : pfdao.listarTodos())
                System.out.println(p.getEmails());
            
            /*
            CursoDAO cdao = new CursoDAO();
            Curso curs = new Curso();
            List<Curso> cs = new LinkedList<>();
            curs.setNome("TADS");
            cs = cdao.buscarCurso(curs);
            
            for(Curso c : cs){
                System.out.println(c.getCursoid());
                System.out.println(c.getNome());
                for(Disciplina d : c.getDisciplinas()){
                    System.out.println(d.getDisciplinaid());
                    System.out.println(d.getAtivo());
                    
                }
                System.out.println("----------------");
            }
            */
            
    }
}
