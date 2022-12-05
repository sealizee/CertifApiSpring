package fr.m2i.certif.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="channels")
public class Channel implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 255, name = "channel_name")
	private String name;
	
	@Column(nullable = false, name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(nullable = false, length = 255, name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
	private List<Message> messages;
	
	
	@Override
	public String toString() {
		return this.id + " : " + this.name + " " + this.createdAt + " " + this.updatedAt + " " + this.description;
	}

}
