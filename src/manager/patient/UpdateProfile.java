package manager.patient;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.Patient;
import models.DAOException;
import models.PatientFacade;
import utils.UtilSession;


@ManagedBean(name = "updateProfilePatient")
@RequestScoped
public class UpdateProfile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Patient patient;
    
	@EJB
    private PatientFacade patientFacade;
    
    public UpdateProfile() {
    	HttpSession session = UtilSession.getSession();
        patient = (Patient) session.getAttribute("patient");
    }

    public String update(Patient patient) throws DAOException {
        patientFacade.update(patient);
        FacesMessage message = new FacesMessage( "You have successfully updated your profile !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "profile_patient";
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
