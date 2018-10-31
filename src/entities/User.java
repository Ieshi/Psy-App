package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;
    
    @NotNull(message = "This field is required")
    @Size(min = 1, max = 10)
    @Column(name = "nom")
    private String nom;
    
    @NotNull(message = "This field is required")
    @Size(min = 1, max = 10)
    @Column(name = "prenom")
    private String prenom;
    
    @NotNull(message = "This field is required")
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    
    @NotNull(message = "This field is required")
    @Pattern(regexp="^(?:212|0)\\s*[5|6](?:[\\s.-]*\\d{2}){4}$", message = "Invalid phone number")
    @Column(name = "tel")
    private String tel;
    
    @NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "sexe")
    private String sexe;
    
    @Size(min = 1, max = 255)
    @Column(name = "photo")
    private String photo = null;
    
    @NotNull(message = "This field is required")
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;


    @NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "mdp")
    private String mdp;
    
    @OneToMany
    private Collection<Message> messages;
    
    @ManyToMany
    private Collection<Sujet> sujets;
    
    public User() {
    }

    /**
     * @return the idUser
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the sexe
     */
    public String getSexe() {
        return sexe;
    }

    /**
     * @param sexe the sexe to set
     */
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * @return the messages
     */
    public Collection<Message> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
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
