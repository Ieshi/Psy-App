package manager.psychologist;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import entities.Psychologue;
import models.DAOException;
import models.PsychologueFacade;

@ManagedBean(name = "psychologists")
@RequestScoped
public class Psychologists implements Serializable{

	private static final long serialVersionUID = 1L;
	private static int parPage = 2;
	
	@ManagedProperty(value = "#{param.pageId}")
	private String pageId;

	private List<Psychologue> psychologues;
	private List<Integer> pages;
	private Integer currentPage;
	
	@EJB
    private PsychologueFacade psychologueFacade;
	
	public Psychologists() {
		psychologues = new ArrayList<Psychologue>();
		pages  = new ArrayList<Integer>();
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		try {
			currentPage = Integer.valueOf(request.getParameter("p"));
		} catch(Exception e) {
			currentPage = 1;
		}
	};
	
	public Collection<Psychologue> pagination() throws DAOException {
		
		pages.clear();
		psychologues.clear();

		int limit        = parPage * (currentPage - 1);
		int psychoNumber = ((Long) psychologueFacade.count()).intValue();
		
		int pagesNumber = (int) Math.round((float)psychoNumber / (float)parPage);
		for(int i = 1; i <= pagesNumber; i++)
			pages.add(i);
		
		Collection<Psychologue> list_psychologues = psychologueFacade.findPsychoPerPage(limit, parPage);
		for(Psychologue psychologue : list_psychologues)
    		psychologues.add(psychologue);
		
    	return psychologues;
	}
	
	public String feedback(String positive, String negative) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
    	float feedback;
    	float pos = Float.valueOf(positive);
    	float neg = Float.valueOf(negative);
    	int sum = (int) (pos + neg);
    	
    	if(pos < neg)
    		return "0 % ("+sum+")";
    	try {
    		feedback = ((pos-neg)/(pos+neg))*100;
    		return df.format(feedback)+" % ("+sum+")";
    	} catch(ArithmeticException e) {
    		return "0 % ("+sum+")";
    	}
    }
	
	public String showPage() {
		return "/psychologist_list.xhtml?faces-redirect=true&p="+pageId;
	}

	public List<Psychologue> getPsychologues() {
		return psychologues;
	}

	public void setPsychologues(List<Psychologue> psychologues) {
		this.psychologues = psychologues;
	}

	public List<Integer> getPages() {
		return pages;
	}

	public void setPagesNumber(List<Integer> pages) {
		this.pages = pages;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
