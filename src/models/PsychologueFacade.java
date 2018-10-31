package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import entities.Psychologue;

@Stateless
public class PsychologueFacade {

	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String COUNT_PSYCHOLOGIST   = "SELECT COUNT(p) FROM Psychologue p";
	private static final String FIND_PSYCHO_PER_PAGE = "SELECT p FROM Psychologue p";
    
    public void register( Psychologue psychologue ) throws DAOException{
        try {
            em.persist( psychologue );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
    
    public void update( Psychologue psychologue ) throws DAOException{
        try {
            em.merge(psychologue);
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
    
    public Object count() throws DAOException{
        Query query = em.createQuery( COUNT_PSYCHOLOGIST );
        try {
        	return query.getSingleResult();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
    
    public Collection<Psychologue> findPsychoPerPage(int limit, int offset) throws DAOException{
		Collection<Psychologue> psychologues = null;
        Query query = em.createQuery( FIND_PSYCHO_PER_PAGE );
        query.setFirstResult(limit).setMaxResults(offset);
        try {
        	psychologues = (Collection<Psychologue>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return psychologues;
    }
    
    public Collection<Psychologue> findPsychoByCriterea(String nom, String prenom, String sexe) throws DAOException{
		Collection<Psychologue> psychologues = null;
		List<String> conditions = new ArrayList();
		
		String req = "SELECT p FROM Psychologue p";
		if(nom != null)
			conditions.add("p.nom LIKE :nom");
		if(prenom != null)
			conditions.add("p.prenom LIKE :prenom");
		if(sexe != null)
			conditions.add("p.sexe =:sexe");
		
		if(conditions.size() != 0)
			req += " WHERE ";
		
		req += StringUtils.join(conditions," AND ");
		
		Query query = em.createQuery( req );
		
		if(nom != null)
			query.setParameter("nom", nom+"%");
		if(prenom != null)
			query.setParameter("prenom", prenom+"%");
		if(sexe != null)
			query.setParameter("sexe", sexe);
		
        try {
        	psychologues = (Collection<Psychologue>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        
        return psychologues;
    }
}
