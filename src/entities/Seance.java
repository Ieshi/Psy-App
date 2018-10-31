package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "seances")
public class Seance implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeance")
    private Integer idSeance;
    

    @NotNull(message = "This field is required")
    @Column(name = "date_seance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSeance;
    

    @NotNull(message = "This field is required")
    @Column(name = "paye")
    private boolean paye = false;
    
    @NotNull(message = "This field is required")
    @Column(name = "annule")
    private boolean annule = false;
    
    @NotNull(message = "This field is required")
    @Column(name = "facture")
    private int facture;
    
    @Size(min = 1, max = 255)
    @Column(name = "transaction")
    private String transaction = null;
    
    @ManyToOne
    @JoinColumn( name = "idPatient")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn( name = "idPsycologue")
    private Psychologue psychologue;
    
    @OneToOne
    private FicheConsultation ficheConsultation;
    
    public Seance() {}

    /**
     * @return the idSeance
     */
    public Integer getIdSeance() {
        return idSeance;
    }

    /**
     * @param idSeance the idSeance to set
     */
    public void setIdSeance(Integer idSeance) {
        this.idSeance = idSeance;
    }

    /**
     * @return the dateSeance
     */
    public Date getDateSeance() {
        return dateSeance;
    }

    /**
     * @param dateSeance the dateSeance to set
     */
    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    /**
     * @return the paye
     */
    public boolean isPaye() {
        return paye;
    }

    /**
     * @param paye the paye to set
     */
    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    /**
     * @return the annule
     */
    public boolean isAnnule() {
        return annule;
    }

    /**
     * @param annule the annule to set
     */
    public void setAnnule(boolean annule) {
        this.annule = annule;
    }

    /**
     * @return the facture
     */
    public int getFacture() {
        return facture;
    }

    /**
     * @param facture the facture to set
     */
    public void setFacture(int facture) {
        this.facture = facture;
    }

    /**
     * @return the transaction
     */
    public String getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the psychologue
     */
    public Psychologue getPsychologue() {
        return psychologue;
    }

    /**
     * @param psychologue the psychologue to set
     */
    public void setPsychologue(Psychologue psychologue) {
        this.psychologue = psychologue;
    }

    /**
     * @return the ficheConsultation
     */
    public FicheConsultation getFicheConsultation() {
        return ficheConsultation;
    }

    /**
     * @param ficheConsultation the ficheConsultation to set
     */
    public void setFicheConsultation(FicheConsultation ficheConsultation) {
        this.ficheConsultation = ficheConsultation;
    }
    
    
}
