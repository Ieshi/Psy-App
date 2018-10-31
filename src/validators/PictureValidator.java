package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;

@FacesValidator( value = "pictureValidator" )
public class PictureValidator implements Validator {
	
	private static String[] extensions = { "jpg", "png", "jpeg" };

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	
        Part file = (Part) value;

        String extension = FilenameUtils.getExtension(file.getSubmittedFileName());
        long size        = (file.getSize()/1024)/1024;
        
        if (size > 1 ) // 1 Mo
        	throw new ValidatorException(new FacesMessage("File too big"));
        else if ( ! ArrayUtils.contains( extensions, extension ) )
            throw new ValidatorException(new FacesMessage("Invalid extension"));
    }
}
