package fr.m2i.certif.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.certif.model.Message;
import fr.m2i.certif.model.User;
import fr.m2i.certif.service.MessageService;
import fr.m2i.certif.service.UserService;

@RestController
@RequestMapping(path="/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<Message> getMessages(){
		
		return messageService.getAll();
	}
	
	
	/*@GetMapping(path = "/find/{id}")
	public User getUser(@PathVariable("id") Long id) { 
	
	userService.getUser(id);
}*/

	@PostMapping(path = "/post", // path / url
			consumes = { "application/json" } // négociation de contenu / par défaut JSON
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postMessage(@RequestBody Message message) {

		messageService.saveMessage(message);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteMessage(@PathVariable("id") Long id) {

		messageService.deleteMessage(id);
		System.out.println("message effacé");

	}
	
}