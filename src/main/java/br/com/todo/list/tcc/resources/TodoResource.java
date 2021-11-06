package br.com.todo.list.tcc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.list.tcc.models.Todo;
import br.com.todo.list.tcc.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value = "/be/todo")
@Api(value = "API REST TODO LIST")
@CrossOrigin(origins = "*")
public class TodoResource {
	
	@Autowired()
	TodoService todoService;
	
	
	@GetMapping("/todos")
	@ApiOperation(value = "retorna todos os todo lists")
	public ResponseEntity<List<Todo>> findAllTodos() {
		return ResponseEntity.ok().body(todoService.findAll());
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "retorna todos os todo lists com user")
	public ResponseEntity<List<Todo>> findOneWithUser(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok().body(todoService.findPostAndUser(id));
	}
	
	@PostMapping("/new")
	@ApiOperation(value = "cria um novo todo")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return ResponseEntity.ok().body(todoService.save(todo));
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "deleta um todo")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") long id) {
		todoService.deleteById(id);
		return ResponseEntity.ok().body("deletado com sucesso");
	}
	

}
