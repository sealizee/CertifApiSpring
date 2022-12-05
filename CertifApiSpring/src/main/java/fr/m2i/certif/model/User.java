package fr.m2i.certif.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255, name = "lastname")
	private String lastname;
	
	@Column(nullable = false, length = 255, name = "firstname")
	private String firstname;
	
	@Column(nullable = false, length = 255, name = "pseudo")
	private String pseudo;
	
	@Column(nullable = false, length = 255, name = "email")
	private String email;
	
	@Column(nullable = false, length = 255, name = "password")
	private String password;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name="users_channels",
        joinColumns = { @JoinColumn(name="user_id") },
        inverseJoinColumns = {@JoinColumn(name="channel_id") }
    )
	private List<Channel> channels;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
	private List<Message> messages;
	

	@Override
	public String toString() {
		return this.id + " : " + this.lastname + " " + this.firstname + " " + this.pseudo + " " + this.email + " " + this.password;
	}
}