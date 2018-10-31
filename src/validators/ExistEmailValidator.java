package validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import models.DAOException;
import models.UserFacade;

@Named(value = "existEmailValidator")
@ManagedBean
@RequestScoped
public class ExistEmailValidator implements Validator {

    @EJB
    private UserFacade userFacade;

    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {

        String email = (String) value;
        
        try {
            if ( userFacade.getUserByEmail( email ) != null ) {
            	throw new ValidatorException(new FacesMessage( FacesMessage.SEVERITY_ERROR, "Email already exists", null));
            }
        } catch ( DAOException e ) {

            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, e.getMessage(), null );
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage( component.getClientId( facesContext ), message );
        }
    }

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}
}
