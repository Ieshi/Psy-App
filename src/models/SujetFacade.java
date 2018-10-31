package models;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Sujet;

@Stateless
public class SujetFacade {
	
	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String FIND_BY_ID_FORUM = "SELECT s FROM Sujet s WHERE s.forum.idForum = :idForum";
    
	public Collection<Sujet> findSujetByIdForum(int idForum) throws DAOException{
		Collection<Sujet> sujets = null;
        Query query = em.createQuery( FIND_BY_ID_FORUM );
        query.setParameter("idForum", idForum);
        try {
        	sujets = (Collection<Sujet>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return sujets;
    }
}
