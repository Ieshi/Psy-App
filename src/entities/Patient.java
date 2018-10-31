package entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(referencedColumnName ="idUser")
public class Patient extends User {
    
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "profession")
    private String profession;
    
	@NotNull(message = "This field is required")
    @Column(name = "poids")
    private float poids;
    
	@NotNull(message = "This field is required")
    @Column(name = "taille")
    private float taille;
    

	@NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "situation_familiale")
    private String situationFamiliale;
    
    @OneToMany
    private Collection<Seance> seances;
    
    @OneToMany
    private Collection<FicheConsultation> ficheConsultations;
    
    public Patient() {}

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return the poids
     */
    public float getPoids() {
        return poids;
    }

    /**
     * @param poids the poids to set
     */
    public void setPoids(float poids) {
        this.poids = poids;
    }

    /**
     * @return the taille
     */
    public float getTaille() {
        return taille;
    }

    /**
     * @param taille the taille to set
     */
    public void setTaille(float taille) {
        this.taille = taille;
    }

    /**
     * @return the situationFamiliale
     */
    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    /**
     * @param situationFamiliale the situationFamiliale to set
     */
    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    /**
     * @return the seances
     */
    public Collection<Seance> getSeances() {
        return seances;
    }

    /**
     * @param seances the seances to set
     */
    public void setSeances(Collection<Seance> seances) {
        this.seances = seances;
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
    
    
    
}
