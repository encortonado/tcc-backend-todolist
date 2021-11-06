package br.com.todo.list.tcc.dto;

import java.io.Serializable;

import br.com.todo.list.tcc.models.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String lastName;
	
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.lastName = user.getLastName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
