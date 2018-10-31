package manager.login;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entities.Patient;
import entities.Psychologue;
import entities.User;
import models.UserFacade;
import utils.UtilSession;

@ManagedBean(name = "loginManager")
@SessionScoped
public class LoginManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;

	@EJB
    private UserFacade userFacade;
	
	public String doLogin(String email, String password) {
		User user = userFacade.login(email, password);
		if (user != null) {
			HttpSession session = UtilSession.getSession();
			if(user instanceof Patient) {
				Patient patient = (Patient) user;
				System.out.println("LOGIN PATIENT : " + patient.getNom() + " " + patient.getPrenom());
				session.setAttribute("patient", patient);
				return "profile_patient";
			}
			else {
				Psychologue psychologue = (Psychologue) user;
				System.out.println("LOGIN PSYCHOLOGUE : " + psychologue.getNom() + " " + psychologue.getPrenom());
				session.setAttribute("psychologue", psychologue);
				return "profile_psychologist";
			}
		} else {
	        FacesMessage message = new FacesMessage( "Incorrect email or passowrd");
	        FacesContext.getCurrentInstance().addMessage( null, message );
	        return "";
		}
	}
	
	public String doLogout() {
		HttpSession session = UtilSession.getSession();
		session.invalidate();
		return "home";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
