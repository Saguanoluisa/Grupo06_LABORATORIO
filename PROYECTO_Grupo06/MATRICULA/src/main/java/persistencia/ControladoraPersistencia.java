package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Agencia;
import logica.Matricula;
import logica.Vehiculo;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    MatriculaJpaController matJPA = new MatriculaJpaController();

    private final EntityManagerFactory emf;

    public ControladoraPersistencia() {
        emf = Persistence.createEntityManagerFactory("MATRICULA_PU");
    }

    public Vehiculo getVehiculoById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public Agencia getAgenciaById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Agencia.class, id);
        } finally {
            em.close();
        }
    }
    
    public void crearMatricula(Matricula mat) {
        matJPA.create(mat);
    }

    public List<Matricula> getMatricula() {
        return matJPA.findMatriculaEntities();
    }
    
    public void borrarMatricula(int id) {
        try {
            matJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Matricula traerMatricula(int id) {
        return matJPA.findMatricula(id);
    }

    public void EditarMatricula(Matricula mat) {
        try {
            matJPA.edit(mat);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
