package models;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Creneau;

@Stateless
public class CreneauFacade {

	@PersistenceContext(unitName = "PsyPU")
    private EntityManager em;
	
	private static final String FIND_BY_ID_PSYCHO = "SELECT c FROM Creneau c WHERE c.psychologue.idUser = :idUser AND c.dateCreneau >= :lundi AND c.dateCreneau <= :vendredi";
    
    public void add( Creneau creneau ) throws DAOException{ 
    	try {
            em.persist( creneau );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
    
    public Collection<Creneau> findCreneauxOfWeekByIdPsycho(int idUser, Date lundi, Date vendredi) throws DAOException{
		
    	Collection<Creneau> creneaux = null;
        Query query = em.createQuery( FIND_BY_ID_PSYCHO );
        query.setParameter("idUser", idUser).setParameter("lundi", lundi).setParameter("vendredi", vendredi);
        try {
        	creneaux = (Collection<Creneau>) query.getResultList();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
        return creneaux;
    }
    
    public void annulerSeance(Date dateCreneau, String seance, int idUser) {
    	
        String ANNULE_SEANCE = "UPDATE Creneau c SET c."+seance+" = false WHERE c.dateCreneau = :dateCreneau AND c.psychologue.idUser = :idUser";
        Query query = em.createQuery( ANNULE_SEANCE );
        int updateCount = query.setParameter("dateCreneau", dateCreneau).setParameter("idUser", idUser).executeUpdate();
        System.out.println("AALALALALALL   " + updateCount);
    }
}
