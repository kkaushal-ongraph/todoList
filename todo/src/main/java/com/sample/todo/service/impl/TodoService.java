package com.sample.todo.service.impl;

import com.sample.todo.config.Constants;
import com.sample.todo.dao.ITodoDAO;
import com.sample.todo.dto.TodoDTO;
import com.sample.todo.entity.TodoEntity;
import com.sample.todo.service.ITodoService;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {

    private final static Logger LOG = LoggerFactory.getLogger(TodoService.class);

    @Autowired
    ITodoDAO todoDAO;

    @Override
    public List<TodoDTO> findallByStatus(Constants.Type status) {


        List<TodoEntity> todoEntities = todoDAO.findAllTodosByStatus(status);

        List<TodoDTO> todoDTOS = new ArrayList<>();

        for(TodoEntity todo : todoEntities)
        {
            TodoDTO todoDTO = new DozerBeanMapper().map(todo, TodoDTO.class);
            todoDTOS.add(todoDTO);
        }
        return todoDTOS;
    }

    @Override
    public List<TodoDTO> findall() {
        List<TodoEntity> todoEntities= todoDAO.findAllTodos();
        List<TodoDTO> todoDTOS = new ArrayList<>();

        for(TodoEntity todo : todoEntities)
        {
            TodoDTO todoDTO = new DozerBeanMapper().map(todo, TodoDTO.class);
            todoDTOS.add(todoDTO);
        }
        return todoDTOS;
    }

    @Transactional
    @Override
    public TodoDTO save(TodoDTO todoDTO) {

        TodoEntity todoEntity = new DozerBeanMapper().map(todoDTO, TodoEntity.class);
        todoDAO.save(todoEntity);
        return todoDTO;
    }

    @Override
    public TodoDTO findbyid(Long id) {
        Optional<TodoEntity> todoEntity = todoDAO.findbyid(id);
        TodoDTO todoDTO = new TodoDTO();
        try {
            todoDTO = new DozerBeanMapper().map(todoEntity.get(), TodoDTO.class);
        }catch(EntityExistsException e)
        {
            return null;
        }
        return todoDTO;
    }

    @Transactional
    @Override
    public void update(TodoDTO todoDTO) {

        TodoEntity todoEntity = todoDAO.findbyid(todoDTO.getId()).get();
        todoEntity.setDescription(todoDTO.getDescription());
        todoEntity.setDate(todoDTO.getDate());
        todoEntity.setTitle(todoDTO.getTitle());
        todoDAO.save(todoEntity);

    }

    @Transactional
    @Override
    public void delete(Long id) {
        todoDAO.delete(id);
    }

    @Override
    @Transactional
    public void updateStatus(Long id) {
        TodoEntity todoEntity = todoDAO.findbyid(id).get();
        todoEntity.setStatus(Constants.Type.COMPLETED);
        todoDAO.save(todoEntity);
    }


}
