package manager.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import entities.Message;
import models.DAOException;
import models.MessageFacade;

@ManagedBean(name = "messageManager")
@ViewScoped
public class MessageManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Message> messages;
	private Integer idSujet;
	private String newMessage;
	
	@EJB
    private MessageFacade messageFacade;
	
	public MessageManager() {
		messages = new ArrayList<Message>();
    	
    	HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
    	try {
			idSujet = Integer.valueOf(request.getParameter("idTopic"));
		} catch(Exception e) {
			idSujet = 1;
		}
    };
    
    @PostConstruct
    public void init(){
    	messages = (List<Message>) messageFacade.findMessageByIdSujet(idSujet);
    }
	
	public void getAllMaladie() throws DAOException {
		messages.clear();
    	Collection<Message> list_messages = messageFacade.findMessageByIdSujet(idSujet);
    	for(Message message : list_messages) {
    		messages.add(message);
    	}
    }
	
	public void addMessage() {
		System.out.println("NEW MESSAGE : " + newMessage);
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Integer getIdSujet() {
		return idSujet;
	}

	public void setIdSujet(Integer idSujet) {
		this.idSujet = idSujet;
	}

	public String getNewMessage() {
		return newMessage;
	}

	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
	}

}
