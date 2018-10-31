package manager.forum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Forum;
import entities.Message;
import entities.Sujet;
import models.DAOException;
import models.ForumFacade;
import models.MessageFacade;
import models.SujetFacade;

@ManagedBean(name = "forumManager")
@SessionScoped
public class ForumManager implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Forum> forums;
	
	@EJB
    private ForumFacade forumFacade;
	@EJB
    private SujetFacade sujetFacade;
	@EJB
    private MessageFacade messageFacade;
	
    public ForumManager() {
    	forums = new ArrayList<Forum>();
    };
	
	public Collection<Forum> getAllForum() throws DAOException {
		forums.clear();
    	Collection<Forum> forumList = forumFacade.findAllForums();
    	for(Forum forum : forumList) {
    		Collection<Sujet> sujetList = sujetFacade.findSujetByIdForum(forum.getIdForum());
    		
    		for(Sujet sujet : sujetList) {
    			Collection<Message> messageList = messageFacade.findMessageByIdSujet(sujet.getIdSujet());
    			sujet.setMessages(messageList);
    		}
    		
    		forum.setSujets(sujetList);
    		forums.add(forum);
    	}
    	return forums;
    }
	
	public String displayTopic() {
	      FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
	      return "/topic.xhtml?faces-redirect=true&idTopic="+params.get("idTopic");
	   }

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}
}
