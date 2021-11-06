package br.com.todo.list.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.todo.list.tcc.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(long id); 
	
	User findByName(String name); 
	
	
	

}
