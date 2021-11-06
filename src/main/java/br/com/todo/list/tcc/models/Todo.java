package br.com.todo.list.tcc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "TB_TODO")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne()
	private User user;
	
	private String name_todo;
	
	private String description;

	private boolean done;
	
	public Todo() {
		
	}

	public Todo(long id, User user, String name_todo, String description, boolean done) {
		super();
		this.id = id;
		this.user = user;
		this.name_todo = name_todo;
		this.description = description;
		this.done = done;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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
