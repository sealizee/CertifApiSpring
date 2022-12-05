package fr.m2i.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.m2i.certif.model.Message;
import fr.m2i.certif.model.User;
import fr.m2i.certif.repository.MessageRepository;
import fr.m2i.certif.repository.UserRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository mr;
	
	public List<Message> getAll(){
		return mr.findAll();
	}

//	public Message getMessageById(Long id){
//		
//		Message message = new Message();
//		
//		List<Message> messages = mr.findAll();
//		for(Message u : messages) {
//			if(u.getId() == id) {
//				message = u;
//			} else {
//				message = null;
//			}
//		}
//		return message;
//	}
	
	public void saveMessage(Message message) {
		mr.save(message);
	}
	
	public void deleteMessage(Long id) {
		mr.deleteById(id);
	}
}