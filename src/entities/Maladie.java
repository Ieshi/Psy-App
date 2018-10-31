package entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "maladies")
public class Maladie implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMaladie")
    private Integer idMaladie;
    
    @NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "nom_maladie")
    private String nomMaladie;

    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "definition")
    private String definition;

    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "commentaire")
    private String commentaire;
    
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "cognitif")
    private String cognitif;

    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "affectif")
    private String affectif;

    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comportemental")
    private String comportemental;

    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "sensori_moteur")
    private String sensoriMoteur;
    
    @OneToMany
    private Collection<FicheConsultation> ficheConsultations;
    
    @ManyToOne
    @JoinColumn( name = "idTrouble")
    private Trouble trouble;
    
    public Maladie() {}

    /**
     * @return the idMaladie
     */
    public Integer getIdMaladie() {
        return idMaladie;
    }

    /**
     * @param idMaladie the idMaladie to set
     */
    public void setIdMaladie(Integer idMaladie) {
        this.idMaladie = idMaladie;
    }

    /**
     * @return the nomMaladie
     */
    public String getNomMaladie() {
        return nomMaladie;
    }

    /**
     * @param nomMaladie the nomMaladie to set
     */
    public void setNomMaladie(String nomMaladie) {
        this.nomMaladie = nomMaladie;
    }

    /**
     * @return the definition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * @param definition the definition to set
     */
    public void setDefinition(String definition) {
        this.definition = definition;
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
     * @return the cognitif
     */
    public String getCognitif() {
        return cognitif;
    }

    /**
     * @param cognitif the cognitif to set
     */
    public void setCognitif(String cognitif) {
        this.cognitif = cognitif;
    }

    /**
     * @return the affectif
     */
    public String getAffectif() {
        return affectif;
    }

    /**
     * @param affectif the affectif to set
     */
    public void setAffectif(String affectif) {
        this.affectif = affectif;
    }

    /**
     * @return the comportemental
     */
    public String getComportemental() {
        return comportemental;
    }

    /**
     * @param comportemental the comportemental to set
     */
    public void setComportemental(String comportemental) {
        this.comportemental = comportemental;
    }

    /**
     * @return the sensoriMoteur
     */
    public String getSensoriMoteur() {
        return sensoriMoteur;
    }

    /**
     * @param sensoriMoteur the sensoriMoteur to set
     */
    public void setSensoriMoteur(String sensoriMoteur) {
        this.sensoriMoteur = sensoriMoteur;
    }

    /**
     * @return the ficheConsultations
     */
    public Collection<FicheConsultation> getFicheConsultations() {
        return ficheConsultations;
    }

    /**
     * @param ficheConsultations the ficheConsultations to set
     */
    public void setFicheConsultations(Collection<FicheConsultation> ficheConsultations) {
        this.ficheConsultations = ficheConsultations;
    }

    /**
     * @return the trouble
     */
    public Trouble getTrouble() {
        return trouble;
    }

    /**
     * @param trouble the trouble to set
     */
    public void setTrouble(Trouble trouble) {
        this.trouble = trouble;
    }
}
