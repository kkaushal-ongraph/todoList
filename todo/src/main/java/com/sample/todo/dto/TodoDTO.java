package com.sample.todo.dto;


import com.sample.todo.config.Constants.Type;

import java.util.Date;

public class TodoDTO
{
    private Long id;
    private String title;
    private String description;
    private Date date;
    private Type status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
