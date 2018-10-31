package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "messages")
public class Message implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private Integer idMessage;

    @NotNull(message = "This field is required")
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "message")
    private String contenu;

    @NotNull(message = "This field is required")
    @Column(name = "date_message")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMessage;
    
    @ManyToOne
    @JoinColumn( name = "idSujet")
    private Sujet sujet;
    
    @ManyToOne
    @JoinColumn( name = "idUser")
    private User user;
    
    public Message() {}

    /**
     * @return the idMessage
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * @param idMessage the idMessage to set
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @param contenu the contenu to set
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * @return the dateMessage
     */
    public Date getDateMessage() {
        return dateMessage;
    }

    /**
     * @param dateMessage the dateMessage to set
     */
    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    /**
     * @return the sujet
     */
    public Sujet getSujet() {
        return sujet;
    }

    /**
     * @param sujet the sujet to set
     */
    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
}
