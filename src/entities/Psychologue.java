package entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "psychologues")
@PrimaryKeyJoinColumn(referencedColumnName = "idUser")
public class Psychologue extends User {
    
	private static final long serialVersionUID = 1L;
    
    @Column(name = "note_positive")
    private int notePositive = 0;
    
    @Column(name = "note_negative")
    private int noteNegative = 0;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descriptif")
    private String descriptif;
    
    @OneToMany
    private Collection<Seance> seances;
    
    @OneToMany
    private Collection<Creneau> creneaux;
    
    @ManyToOne
    @JoinColumn( name = "idTrouble")
    private Trouble trouble;
    
   public Psychologue() {}

    /**
     * @return the notePositive
     */
    public int getNotePositive() {
        return notePositive;
    }

    /**
     * @param notePositive the notePositive to set
     */
    public void setNotePositive(int notePositive) {
        this.notePositive = notePositive;
    }

    /**
     * @return the noteNegative
     */
    public int getNoteNegative() {
        return noteNegative;
    }

    /**
     * @param noteNegative the noteNegative to set
     */
    public void setNoteNegative(int noteNegative) {
        this.noteNegative = noteNegative;
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
     * @return the creneaux
     */
    public Collection<Creneau> getCreneaux() {
        return creneaux;
    }

    /**
     * @param creneaux the creaneaux to set
     */
    public void setCreneaux(Collection<Creneau> creneaux) {
        this.creneaux = creneaux;
    }

	public Trouble getTrouble() {
		return trouble;
	}

	public void setTrouble(Trouble trouble) {
		this.trouble = trouble;
	}
}
