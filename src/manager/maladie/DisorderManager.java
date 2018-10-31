package manager.maladie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import entities.Maladie;
import entities.Trouble;
import models.DAOException;
import models.MaladieFacade;
import models.TroubleFacade;

@ManagedBean(name = "disorderManager")
@ViewScoped
public class DisorderManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Trouble> troubles;
	private List<Maladie> maladies;
	private List<Maladie> searchMaladies;
	private Maladie maladie;
	private String searchText;
	private Integer idMaladie;
	
	@EJB
    private MaladieFacade maladieFacade;
	@EJB
    private TroubleFacade troubleFacade;
	
    public DisorderManager() {
    	troubles 	   = new ArrayList<Trouble>();
    	maladies       = new ArrayList<Maladie>();
    	searchMaladies = new ArrayList<Maladie>();
    	maladie		   = new Maladie();
    	
    	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		try {
			idMaladie = Integer.valueOf(request.getParameter("idTopic"));
		} catch(Exception e) {
			idMaladie = 1;
		}
    };
    
    @PostConstruct
    public void init(){
    	maladie = maladieFacade.findById(idMaladie);
    }

    public Collection<Trouble> getAllTrouble() throws DAOException {
    	troubles.clear();
    	Collection<Trouble> list_troubles = troubleFacade.findAllTrouble();
    	for(Trouble trouble : list_troubles)
    		troubles.add(trouble);
    	return troubles;
    }
    
    public Collection<Maladie> getAllMaladie() throws DAOException {
    	maladies.clear();
    	Collection<Maladie> list_maladies = maladieFacade.findAllDisorders();
    	for(Maladie maladie : list_maladies) {
    		maladies.add(maladie);
    	}
    	return maladies;
    }

    public String add(Maladie maladie) throws DAOException {
    	maladieFacade.add(maladie);
        FacesMessage message = new FacesMessage( "You have successfully added the disorder" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        return "admin";
    }
    
    public Trouble findTrouble(Integer idTrouble) {
        if (idTrouble == null)
            throw new IllegalArgumentException("No idTrouble provided");
        for (int i = 0; i < troubles.size(); i++) {
			if (idTrouble.equals(troubles.get(i).getIdTrouble()))
			{
				System.out.println(troubles.get(i).getNomTrouble());
				return troubles.get(i);
			}
		}
        return null;
    }
    
    public void search() {
    	searchMaladies.clear();
    	if(searchText != null) {
    		for(int i=0; i<maladies.size(); i++) {
	    		if(maladies.get(i).getNomMaladie().toLowerCase().startsWith(searchText.toLowerCase()))
	    			searchMaladies.add(maladies.get(i));
	    	}
    	}
    }
    
	public List<Trouble> getTroubles() {
		return troubles;
	}

	public void setTroubles(List<Trouble> troubles) {
		this.troubles = troubles;
	}

	public List<Maladie> getMaladies() {
		return maladies;
	}

	public void setMaladies(List<Maladie> maladies) {
		this.maladies = maladies;
	}

	public List<Maladie> getSearchMaladies() {
		return searchMaladies;
	}

	public void setSearchMaladies(List<Maladie> searchMaladies) {
		this.searchMaladies = searchMaladies;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Maladie getMaladie() {
		return maladie;
	}

	public void setMaladie(Maladie maladie) {
		this.maladie = maladie;
	}

	public Integer getIdMaladie() {
		return idMaladie;
	}

	public void setIdMaladie(Integer idMaladie) {
		this.idMaladie = idMaladie;
	}
}
