package com.sample.todo.entity;

import com.sample.todo.config.Constants;
import org.dozer.DozerBeanMapper;
import org.hibernate.engine.jdbc.spi.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "todo")
public class TodoEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title can't be null")
    @Column(name = "title")
    private String title;


    @NotNull(message = "description can't be null")
    @Column(name = "description")
    private String description;

    @NotNull(message = "date can't be null")
    @Column(name = "DateAndTime")
    private Date date;

    @Enumerated(EnumType.STRING)
    private Constants.Type status;



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

    public Constants.Type getStatus() {
        return status;
    }

    public void setStatus(Constants.Type status) {
        this.status = status;
    }

    @PrePersist
    public void persistGuid() {
        this.status = Constants.Type.INPROGRESS;
    }
}
