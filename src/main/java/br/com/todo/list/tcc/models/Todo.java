package br.com.todo.list.tcc.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(targetEntity = User.class)
	private long id_user;
	
	private String name_todo;
	
	private String description;

	private boolean done;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public String getName_todo() {
		return name_todo;
	}

	public void setName_todo(String name_todo) {
		this.name_todo = name_todo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	
	
	
}
