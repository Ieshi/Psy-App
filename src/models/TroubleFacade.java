package models;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Trouble;
import entities.User;

@Stateless
public class TroubleFacade {
    
	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String FIND_ALL_TROUBLE = "SELECT t FROM Trouble t";
	private static final String FIND_BY_ID       = "SELECT t FROM Trouble t WHERE t.idTrouble = :id";
	
	public Collection<Trouble> findAllTrouble() throws DAOException{
		Collection<Trouble> troubles = null;
        Query query = em.createQuery( FIND_ALL_TROUBLE );
        try {
        	troubles = (Collection<Trouble>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return troubles;
    }
	
	public Trouble findById(int idTrouble) throws DAOException{
		
		Trouble trouble = null;
		
		Query query = em.createQuery(FIND_BY_ID);
        query.setParameter( "id", idTrouble );
        
        try {
        	trouble = (Trouble) query.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return trouble;
	}
}