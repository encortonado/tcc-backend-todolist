package br.com.todo.list.tcc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.list.tcc.models.User;
import br.com.todo.list.tcc.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value = "/login")
@Api(value = "API REST USUARIOS")
@CrossOrigin(origins = "*")
public class UserResource {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	@ApiOperation(value = "retorna todos os usuarios")
	public List<User> listUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "retorna um usuario")
	public User listUser(@PathVariable(value = "id") long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping("/user/new")
	@ApiOperation(value = "cria um novo usuario")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "deleta um usuario")
	public void deleteUser(@PathVariable(value = "id") long id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("/user/edit")
	@ApiOperation(value = "edita um usuario")
	public User updateUser(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
}

















