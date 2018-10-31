package models;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Maladie;

@Stateless
public class MaladieFacade {
    
	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String FIND_ALL = "SELECT m FROM Maladie m";
    
    public void add( Maladie maladie ) throws DAOException{
        try {
            em.persist( maladie );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

	public Collection<Maladie> findAllDisorders() throws DAOException{
		Collection<Maladie> maladies = null;
        Query query = em.createQuery( FIND_ALL );
        try {
        	maladies = (Collection<Maladie>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return maladies;
    }
	
	public Maladie findById(int idMaladie) {
		
		Maladie maladie = null;
		
		try {
			maladie = em.find(Maladie.class, idMaladie);
		} catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
		
		return maladie;
	}
}
