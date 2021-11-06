package br.com.todo.list.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.todo.list.tcc.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

	
	@Query(value = "select t.*, u.name from tb_todo as t inner join tb_user u  on u.id = t.user_id where u.id = ?1", nativeQuery = true)
	List<Todo> findPostAndUser(long id);
	
}
