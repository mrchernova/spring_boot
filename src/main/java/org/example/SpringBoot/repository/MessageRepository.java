package org.example.SpringBoot.repository;

import org.example.SpringBoot.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
