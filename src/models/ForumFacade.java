package models;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Forum;
import entities.Sujet;

@Stateless
public class ForumFacade {
	
	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String FIND_ALL = "SELECT f FROM Forum f";
    

	public Collection<Forum> findAllForums() throws DAOException{
		Collection<Forum> forums = null;
        Query query = em.createQuery( FIND_ALL, Sujet.class );
        try {
        	forums = (Collection<Forum>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return forums;
    }
}
