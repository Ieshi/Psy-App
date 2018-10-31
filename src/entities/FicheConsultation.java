package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fiche_consultations")
public class FicheConsultation implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFiche")
    private Integer idFiche;
    
    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "commentaire")
    private String commentaire;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "appreciation_retroactive")
    private String appreciationRetroactive;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "diagnostic")
    private String diagnostic;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prescription")
    private String prescription;
    
    @ManyToOne
    @JoinColumn( name = "idPatient")
    private Patient patient;
    
    @OneToOne
    @JoinColumn(name = "idSeance")
    private Seance seance;
    
    @ManyToOne
    @JoinColumn( name = "idMaladie")
    private Maladie maladie;
    
    public FicheConsultation() {}

    /**
     * @return the idFiche
     */
    public Integer getIdFiche() {
        return idFiche;
    }

    /**
     * @param idFiche the idFiche to set
     */
    public void setIdFiche(Integer idFiche) {
        this.idFiche = idFiche;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * @return the appreciationRetroactive
     */
    public String getAppreciationRetroactive() {
        return appreciationRetroactive;
    }

    /**
     * @param appreciationRetroactive the appreciationRetroactive to set
     */
    public void setAppreciationRetroactive(String appreciationRetroactive) {
        this.appreciationRetroactive = appreciationRetroactive;
    }

    /**
     * @return the diagnostic
     */
    public String getDiagnostic() {
        return diagnostic;
    }

    /**
     * @param diagnostic the diagnostic to set
     */
    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    /**
     * @return the prescription
     */
    public String getPrescription() {
        return prescription;
    }

    /**
     * @param prescription the prescription to set
     */
    public void setPrescription(String prescription) {
        this.prescription = prescription;
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
     * @return the seance
     */
    public Seance getSeance() {
        return seance;
    }

    /**
     * @param seance the seance to set
     */
    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    /**
     * @return the maladie
     */
    public Maladie getMaladie() {
        return maladie;
    }

    /**
     * @param maladie the maladie to set
     */
    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }
    
    
    
}
