package manager.seance;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Psychologue;
import models.PsychologueFacade;

@ManagedBean(name = "seanceManager")
@SessionScoped
public class SeanceManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Psychologue> psychologues;
	private String nom = null;
	private String prenom = null;
	private String sexe = null;
	private String feedback = null;
	private String seance = null;
	
	@EJB
    private PsychologueFacade psychologueFacade;
	
	public SeanceManager() {
		psychologues = new ArrayList<Psychologue>();
	}
	
	@PostConstruct
	public void init() {
		Collection<Psychologue> list_psychologues = psychologueFacade.findPsychoByCriterea(nom, prenom, sexe);
		for(Psychologue psychologue : list_psychologues)
    		psychologues.add(psychologue);
	}
	
	public void searchPsychologist() {
		
		psychologues.clear();
		Collection<Psychologue> list_psychologues = psychologueFacade.findPsychoByCriterea(nom, prenom, sexe);
		for(Psychologue psychologue : list_psychologues)
    		psychologues.add(psychologue);
	}

	public void make_appointment(int idUser) {
		System.out.println("ID USER " + idUser);
	}
	
	public String feedback(String positive, String negative) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
    	float feedback;
    	float pos = Float.valueOf(positive);
    	float neg = Float.valueOf(negative);

    	if(pos < neg)
    		return "0%";
    	try {
    		feedback = ((pos-neg)/(pos+neg))*100;
    		return df.format(feedback)+"%";
    	} catch(ArithmeticException e) {
    		return "0%";
    	}
    }
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public List<Psychologue> getPsychologues() {
		return psychologues;
	}

	public void setPsychologues(List<Psychologue> psychologues) {
		this.psychologues = psychologues;
	}

	public String getSeance() {
		return seance;
	}

	public void setSeance(String seance) {
		this.seance = seance;
	}
}
