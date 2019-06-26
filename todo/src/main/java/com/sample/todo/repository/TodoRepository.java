package com.sample.todo.repository;

import com.sample.todo.config.Constants;
import com.sample.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findAllByStatus(Constants.Type status);
}
