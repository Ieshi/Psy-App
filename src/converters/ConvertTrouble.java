package converters;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import entities.Trouble;
import manager.maladie.DisorderManager;

@FacesConverter("convertTrouble")
public class ConvertTrouble implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ValueExpression vex =
				arg0.getApplication().getExpressionFactory()
                        .createValueExpression(arg0.getELContext(),
                                "#{disorderManager}", DisorderManager.class);

		DisorderManager disorderManager = (DisorderManager) vex.getValue(arg0.getELContext());
        return disorderManager.findTrouble(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 == null)
			return "";
		return String.valueOf(((Trouble) arg2).getIdTrouble());
	}
}
