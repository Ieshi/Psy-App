package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sujets")
public class Sujet implements Serializable  {
    
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSujet")
    private Integer idSujet;

    @NotNull(message = "This field is required")
    @Size(min = 1, max = 255)
    @Column(name = "sujet")
    private String nomSujet;
    
    @OneToMany
    private Collection<Message> messages;
    
    @ManyToOne
    @JoinColumn( name = "idForum")
    private Forum forum;
    
    @ManyToMany
    private Collection<User> users;
    
    public Sujet() {}

    /**
     * @return the idSujet
     */
    public Integer getIdSujet() {
        return idSujet;
    }

    /**
     * @param idSujet the idSujet to set
     */
    public void setIdSujet(Integer idSujet) {
        this.idSujet = idSujet;
    }

    /**
     * @return the sujet
     */
    public String getNomSujet() {
        return nomSujet;
    }

    /**
     * @param sujet the sujet to set
     */
    public void setNomSujet(String nomSujet) {
        this.nomSujet = nomSujet;
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
     * @return the forum
     */
    public Forum getForum() {
        return forum;
    }

    /**
     * @param forum the forum to set
     */
    public void setForum(Forum forum) {
        this.forum = forum;
    }

    /**
     * @return the users
     */
    public Collection<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Collection<User> users) {
        this.users = users;
    }
    
    
}
