package br.com.todo.list.tcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todo.list.tcc.models.Todo;
import br.com.todo.list.tcc.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired()
	TodoRepository todoRepository;
	
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}
	
	public List<Todo> findPostAndUser(long id) {
		return todoRepository.findPostAndUser(id);
	}
	
	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public void deleteById(long id) {
		todoRepository.deleteById(id);
	}
	
}
