package fr.m2i.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.m2i.certif.model.User;
import fr.m2i.certif.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	public List<User> getAll(){
		return ur.findAll();
	}

	/*public User getUserById(Long id){
		
		User user = new User();
		
		List<User> users = ur.findAll();
		for(User u : users) {
			if(u.getId() == id) {
				user = u;
			} else {
				user = null;
			}
		}
		return user;
	}*/
	
	public void saveUser(User user) {
		ur.save(user);
	}
	
	public void deleteUser(Long id) {
		ur.deleteById(id);
	}
}