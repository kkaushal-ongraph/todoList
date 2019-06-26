package com.sample.todo.dao;


import com.sample.todo.config.Constants;
import com.sample.todo.entity.TodoEntity;

import java.util.List;
import java.util.Optional;

public interface ITodoDAO  {

    List<TodoEntity> findAllTodosByStatus(Constants.Type status);
    List<TodoEntity> findAllTodos();
    void save(TodoEntity todoEntity);
    Optional<TodoEntity> findbyid(Long id);
    void delete(Long id);
}
