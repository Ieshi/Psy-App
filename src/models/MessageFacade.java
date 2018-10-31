package models;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Maladie;
import entities.Message;

@Stateless
public class MessageFacade {

	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String FIND_BY_ID_FORUM = "SELECT m FROM Message m WHERE m.sujet.idSujet = :idSujet ORDER BY m.dateMessage DESC";
    
	public Collection<Message> findMessageByIdSujet(int idSujet) throws DAOException{
		Collection<Message> messages = null;
        Query query = em.createQuery( FIND_BY_ID_FORUM );
        query.setParameter("idSujet", idSujet);
        try {
        	messages = (Collection<Message>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return messages;
    }
}
