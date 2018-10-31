package models;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Patient;

@Stateless
public class PatientFacade {
    
	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
    
    public void register( Patient patient ) throws DAOException{
        try {
            em.persist( patient );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
    
    public void update( Patient patient ) throws DAOException{
        try {
            em.merge(patient);
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
}
