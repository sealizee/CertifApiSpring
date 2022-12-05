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


import fr.m2i.certif.model.User;
import fr.m2i.certif.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping(path = "/list", produces = {"application/json"})
	public List<User> getUsers(){
		
		return userService.getAll();
	}
	
	
	/*@GetMapping(path = "/find/{id}", produces = {"application/json"})
	public User getUser(@PathVariable("id") Long id) { 
	
	return userService.getUserById(id);
}*/

	@PostMapping(path = "/post", // path / url
			consumes = { "application/json" } // négociation de contenu / par défaut JSON
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postUser(@RequestBody User user) {

		userService.saveUser(user);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void deleteUser(@PathVariable("id") Long id) {

		userService.deleteUser(id);
		System.out.println("user effacé");

	}
	
}