package models;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Patient;
import entities.Psychologue;
import entities.User;

@Stateless
public class UserFacade {
	
	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String FIND_USER_BY_EMAIL = "SELECT u FROM User u WHERE u.email = :email";
	private static final String LOGIN_PSYCHOLOGUE  = "SELECT p FROM Psychologue p WHERE p.email = :email AND p.mdp = :password";
	private static final String LOGIN_PATIENT      = "SELECT p FROM Patient p WHERE p.email = :email AND p.mdp = :password";
	
	public User login( String email, String password ) throws DAOException {
		
		Psychologue psychologue = null;
		Patient patient = null;
		
        Query query = em.createQuery(LOGIN_PSYCHOLOGUE);
        query.setParameter( "email", email ).setParameter("password", password);
        try {
        	psychologue = (Psychologue) query.getSingleResult();
        } catch ( NoResultException e1 ) {
        	query = em.createQuery(LOGIN_PATIENT);
            query.setParameter( "email", email ).setParameter("password", password);
        	try {
        		patient = (Patient) query.getSingleResult();
        	} catch ( NoResultException e2 ) {
        		return null;
        	}
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        
        if(patient == null)
        	return psychologue;
        else
        	return patient;
    }
	
	public User getUserByEmail( String email ) throws DAOException {
		
		User user = null;
        Query query = em.createQuery( FIND_USER_BY_EMAIL );
        query.setParameter( "email", email );
        try {
        	user = (User) query.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return user;
    }

}
