package br.com.todo.list.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.list.tcc.models.User;
import br.com.todo.list.tcc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	
	public User findById(long id) {
		return userRepository.findById(id);
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(long id) {
		userRepository.deleteById(id);
	}

}
