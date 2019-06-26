package com.sample.todo.dao.impl;

import com.sample.todo.config.Constants;
import com.sample.todo.dao.ITodoDAO;
import com.sample.todo.entity.TodoEntity;
import com.sample.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoDAO implements ITodoDAO {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<TodoEntity> findAllTodosByStatus(Constants.Type status) {
        List<TodoEntity> todoEntities = todoRepository.findAllByStatus(status);
        return todoEntities;
    }

    @Override
    public List<TodoEntity> findAllTodos() {
        List<TodoEntity> todoEntities=todoRepository.findAll();
        return todoEntities;
    }

    @Override
    public void save(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
    }

    @Override
    public Optional<TodoEntity> findbyid(Long id) {
        Optional<TodoEntity> todoEntity = todoRepository.findById(id);
        return todoEntity;
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }


}

