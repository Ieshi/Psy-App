package entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "forums")
public class Forum implements Serializable  {
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForum")
    private Integer idForum;
    
    @NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "nom_forum")
    private String nomForum;
    
    @OneToMany
    private Collection<Sujet> sujets;
    
    public Forum() {}

    /**
     * @return the idForum
     */
    public Integer getIdForum() {
        return idForum;
    }

    /**
     * @param idForum the idForum to set
     */
    public void setIdForum(Integer idForum) {
        this.idForum = idForum;
    }

    /**
     * @return the nomForum
     */
    public String getNomForum() {
        return nomForum;
    }

    /**
     * @param nomForum the nomForum to set
     */
    public void setNomForum(String nomForum) {
        this.nomForum = nomForum;
    }

    /**
     * @return the sujets
     */
    public Collection<Sujet> getSujets() {
        return sujets;
    }

    /**
     * @param sujets the sujets to set
     */
    public void setSujets(Collection<Sujet> sujets) {
        this.sujets = sujets;
    }
    
    
}
