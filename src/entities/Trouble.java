package entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "troubles")
public class Trouble implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTrouble")
    private Integer idTrouble;
    
    @NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "nom_trouble")
    private String nomTrouble;
    
    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descriptif")
    private String descriptif;
    
    @OneToMany
    private Collection<Maladie> maladies;
    
    @OneToMany
    private Collection<Psychologue> psychologues;
    
    public Trouble() {}

    /**
     * @return the idTrouble
     */
    public Integer getIdTrouble() {
        return idTrouble;
    }

    /**
     * @param idTrouble the idTrouble to set
     */
    public void setIdTrouble(Integer idTrouble) {
        this.idTrouble = idTrouble;
    }

    /**
     * @return the nomTrouble
     */
    public String getNomTrouble() {
        return nomTrouble;
    }

    /**
     * @param nomTrouble the nomTrouble to set
     */
    public void setNomTrouble(String nomTrouble) {
        this.nomTrouble = nomTrouble;
    }

    /**
     * @return the descriptif
     */
    public String getDescriptif() {
        return descriptif;
    }

    /**
     * @param descriptif the descriptif to set
     */
    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    /**
     * @return the maladies
     */
    public Collection<Maladie> getMaladies() {
        return maladies;
    }

    /**
     * @param maladies the maladies to set
     */
    public void setMaladies(Collection<Maladie> maladies) {
        this.maladies = maladies;
    }

    /**
     * @return the psychologues
     */
    public Collection<Psychologue> getPsychologues() {
        return psychologues;
    }

    /**
     * @param psychologues the psychologues to set
     */
    public void setPsychologues(Collection<Psychologue> psychologues) {
        this.psychologues = psychologues;
    }
    
    
}
