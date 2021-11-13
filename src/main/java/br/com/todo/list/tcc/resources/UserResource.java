package br.com.todo.list.tcc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.list.tcc.models.Login;
import br.com.todo.list.tcc.models.User;
import br.com.todo.list.tcc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value = "/be/login")
@Api(value = "API REST USUARIOS")
@CrossOrigin(origins = "*")
public class UserResource {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	@ApiOperation(value = "retorna todos os usuarios")
	public ResponseEntity<List<User>>  listUsers() {
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping("/user/find/{id}")
	@ApiOperation(value = "retorna um usuario pelo id")
	public ResponseEntity<User> listUser(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok().body(userService.findById(id));
	}
	
	@GetMapping("/user/search/{name}")
	@ApiOperation(value = "retorna um usuario pelo nome")
	public Object listUserByName(@PathVariable(value = "name") String name) {
		
		try {
			name = name.toLowerCase();
			return userService.findByName(name);
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	@PostMapping("/user/new")
	@ApiOperation(value = "cria um novo usuario")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		user.setName(user.getName().toLowerCase());
		user.setLastName(user.getLastName().toLowerCase());
		user.setEmail(user.getEmail().toLowerCase());
		return ResponseEntity.ok().body(userService.save(user));
	}
	
	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "deleta um usuario")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") long id) {
		userService.deleteById(id);
		return ResponseEntity.ok().body("deletado com sucesso");
	}
	
	@PutMapping("/user/edit")
	@ApiOperation(value = "edita um usuario")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		return ResponseEntity.ok().body(userService.save(user));
	}
	
	@GetMapping("/user/auth")
	@ApiOperation(value = "Busca um usuario e senha e indica se o request passado está correto")
	public ResponseEntity<User> userToAuth(@RequestBody Login login) {
		
		try {
			
			User user = userService.findByName(login.getName().toLowerCase());
			if (user.getPassword() == login.getPassword()) {
				return ResponseEntity.ok().body(user);
			} else {
				return ResponseEntity.internalServerError().build();
			}
			
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
		
		
	}
	
}

















