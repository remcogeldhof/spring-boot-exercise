package be.optis.repository;

import be.optis.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByContextTag(String context);
}
