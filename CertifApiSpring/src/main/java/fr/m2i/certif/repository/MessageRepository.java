package fr.m2i.certif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.m2i.certif.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
