package manager.register;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import entities.Psychologue;
import models.DAOException;
import models.PsychologueFacade;

@ManagedBean(name = "registerPsychologueManager")
@RequestScoped
public class RegisterPsychologueManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	static private String imagePath = "D:\\Utilisateurs\\Ayman\\Documents\\JavaEEProjects\\psychologie\\WebContent\\resources\\images\\users\\";
	
	private Psychologue psychologue;
	private Part image;
    
	@EJB
    private PsychologueFacade psychologueFacade;
    
    public RegisterPsychologueManager() {
    	psychologue = new Psychologue();
    }

    public void register(Psychologue psychologue) throws DAOException {
    	try {
    		InputStream in = image.getInputStream();
    		
    		System.out.println(imagePath + image.getSubmittedFileName());
    		File f = new File(imagePath + image.getSubmittedFileName());
    		f.createNewFile();
    		FileOutputStream out = new FileOutputStream(f);
    		
    		byte[] buffer = new byte[1024];
    		int length;
    		
    		while((length = in.read(buffer)) > 0) {
    			out.write(buffer, 0, length);
    		}
    		
    		out.close();
    		in.close();
    		
    		psychologue.setPhoto(image.getSubmittedFileName());
	    	psychologueFacade.register(psychologue);
	        FacesMessage message = new FacesMessage( "You have successfully registered !" );
	        FacesContext.getCurrentInstance().addMessage( null, message );
	        
    	} catch(Exception e) {
    		e.printStackTrace(System.out);
    	}
    }

	public Psychologue getPsychologue() {
		return psychologue;
	}

	public void setPsychologue(Psychologue psychologue) {
		this.psychologue = psychologue;
	}
	
	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}
}
