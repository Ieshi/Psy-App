package creneauManager;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateUtils;

import entities.Creneau;
import entities.Psychologue;
import models.CreneauFacade;
import utils.UtilSession;

@ManagedBean(name = "creneauManager")
@ViewScoped
public class CreneauManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private List<Creneau> creneaux;
    private Creneau creneau;
    private Date date;
    private Date heureDebut;
    private Date heureFin;
    private Psychologue psychologue;
    private DateFormat formatter;
    private Date lundi;
    private Date vendredi;
    private Map<String, String> horaires;
    
    public DateFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(DateFormat formatter) {
		this.formatter = formatter;
	}

	@EJB
    private CreneauFacade creneauFacade;
    
    public CreneauManager() {
    	HttpSession session = UtilSession.getSession();
    	psychologue = (Psychologue) session.getAttribute("psychologue");
    	
    	creneaux  = new ArrayList<Creneau>();
    	creneau   = new Creneau();
    	formatter = new SimpleDateFormat("yyyy-MM-dd");
    	horaires  = new HashMap<>();
    	horaires.put("08:00", "s1");
    	horaires.put("11:00", "s2");
    	horaires.put("14:00", "s3");
    	horaires.put("17:00", "s4");
    	horaires.put("20:00", "s5");
    	
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    	lundi = cal.getTime();
    	cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 4);
    	vendredi = cal.getTime();
    }
    
    @PostConstruct
    public void init() {
    	creneaux = (List<Creneau>) creneauFacade.findCreneauxOfWeekByIdPsycho(psychologue.getIdUser(), lundi, vendredi);
    }
     
    public void annulerSeance() {
    	
        SimpleDateFormat ft1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ft2 = new SimpleDateFormat("HH:00");
        
        try {
			creneauFacade.annulerSeance(ft1.parse(ft1.format(date)), horaires.get(ft2.format(heureDebut)), psychologue.getIdUser());
			creneaux = (List<Creneau>) creneauFacade.findCreneauxOfWeekByIdPsycho(psychologue.getIdUser(), lundi, vendredi);
		} catch (ParseException e) {
			e.printStackTrace();
		}

        heureFin = DateUtils.addHours(heureDebut, 2);
        FacesMessage message = new FacesMessage( "La séance programmée le "+ft1.format(date)+" de "+ft2.format(heureDebut)+" à "+ft2.format(heureFin)+" a été annulé");
        FacesContext.getCurrentInstance().addMessage( null, message );
    }
    
    public void genererSeances() {
    	Calendar cal = Calendar.getInstance();
    	Date jour;
    	
    	for(int i=0; i<5; i++) {
        	cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + i);
        	jour = cal.getTime();
        	try {
				jour = formatter.parse(formatter.format(jour));
				System.out.println("JOUR " + i + " : " + jour);
			} catch (ParseException e) {
				e.printStackTrace();
			}
        	
        	creneau.setPsychologue(psychologue);
        	creneau.setDateCreneau(jour);
        	
        	creneauFacade.add(creneau);
        	
        	creneaux.add(creneau);
        }
    }
    
    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public Creneau getCreneau() {
		return creneau;
	}

	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	public Date getLundi() {
		return lundi;
	}

	public void setLundi(Date lundi) {
		this.lundi = lundi;
	}

	public Date getVendredi() {
		return vendredi;
	}

	public void setVendredi(Date vendredi) {
		this.vendredi = vendredi;
	}

	public Map<String, String> getHoraires() {
		return horaires;
	}

	public void setHoraires(Map<String, String> horaires) {
		this.horaires = horaires;
	}
}
