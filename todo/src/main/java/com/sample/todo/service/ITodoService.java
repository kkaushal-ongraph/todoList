package com.sample.todo.service;

import com.sample.todo.config.Constants;
import com.sample.todo.dto.TodoDTO;

import java.util.List;


public interface ITodoService  {

    public List<TodoDTO> findallByStatus(Constants.Type status);
    public List<TodoDTO> findall();
    public TodoDTO save(TodoDTO todoDTO);
    public TodoDTO findbyid(Long id);
    public void update(TodoDTO todoDTO);
    public void delete(Long id);
    public void updateStatus(Long id);

}
