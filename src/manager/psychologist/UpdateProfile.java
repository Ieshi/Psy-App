package manager.psychologist;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.Psychologue;
import models.DAOException;
import models.PsychologueFacade;
import utils.UtilSession;

@ManagedBean(name = "updateProfilePsychologue")
@RequestScoped
public class UpdateProfile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Psychologue psychologue;
    
	@EJB
    private PsychologueFacade psychologueFacade;
    
    public UpdateProfile() {
    	HttpSession session = UtilSession.getSession();
    	psychologue = (Psychologue) session.getAttribute("psychologue");
    }

    public String update(Psychologue psychologue) throws DAOException {
    	psychologueFacade.update(psychologue);
        FacesMessage message = new FacesMessage( "You have successfully updated your profile !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "profile_psychologist";
    }

	public Psychologue getPsychologue() {
		return psychologue;
	}

	public void setPsychologue(Psychologue psychologue) {
		this.psychologue = psychologue;
	}

    
}
