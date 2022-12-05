package fr.m2i.certif.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2i.certif.model.Channel;

import fr.m2i.certif.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	ChannelRepository cr;

	public List<Channel> getAll() {
		return cr.findAll();
	}

	/*
	 * public User getUserById(Long id){
	 * 
	 * User user = new User();
	 * 
	 * List<User> users = ur.findAll(); for(User u : users) { if(u.getId() == id) {
	 * user = u; } else { user = null; } } return user; }
	 */

	public void saveChannel(Channel channel) {
		cr.save(channel);
	}

	public void deleteChannel(Long id) {
		cr.deleteById(id);
	}
}