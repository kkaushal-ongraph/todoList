package com.sample.todo.controller;


import com.sample.todo.config.Constants;
import com.sample.todo.dto.TodoDTO;
import com.sample.todo.service.ITodoService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

@RestController
@CrossOrigin
@RequestMapping("/todo")
public class Controller {

    static final Logger logger = Logger.getLogger(Controller.class);



    @Autowired
    ITodoService iTodoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoDTO> showAllInProgressTasks() {
        List<TodoDTO> todoDTOS=new ArrayList<>();
           todoDTOS = iTodoService.findallByStatus(Constants.Type.INPROGRESS);
        return todoDTOS;
    }

    @RequestMapping(value = "/completedTasks",method = RequestMethod.GET)
    public List<TodoDTO> showallCompleted() {
        List<TodoDTO> todoDTOS=new ArrayList<>();
        todoDTOS = iTodoService.findall();
        return todoDTOS;
    }

    @RequestMapping(value = "/markCompleted/{id}",method = RequestMethod.GET)
    public Response updateStatus(@PathVariable(value = "id") Long id){
        iTodoService.updateStatus(id);
        return Response.ok().build();
    }


    //Create Todo
    @RequestMapping(method = RequestMethod.POST)
    public Response add(@Valid  @RequestBody TodoDTO todoDTO) {

        TodoDTO todoDTO1;
        if(todoDTO.getId()!=null){
            iTodoService.update(todoDTO);
            return Response.ok(todoDTO).build();
        }
        try {
              todoDTO1 = iTodoService.save(todoDTO);
        }catch (Exception e)
        {
                logger.error("Error :-" + e.getLocalizedMessage());
                return Response.status(500).entity(e.getLocalizedMessage()).build();
        }
       return Response.ok(todoDTO1).build();
    }

    //FindTOdoByID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TodoDTO findbyid(@PathVariable(value = "id") Long id)
    {
        TodoDTO todoDTO=new TodoDTO() ;
        try {
            todoDTO = iTodoService.findbyid(id);
        }catch (Exception e)
        {
            logger.error("Error :-" + e.getLocalizedMessage());
        //    return Response.status(500).entity(e.getLocalizedMessage()).build();
        }

        return todoDTO;
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
    public Response update(@PathVariable(value = "id") Long id, @Valid @RequestBody TodoDTO todoDTO )
    {
        TodoDTO todoDTO1  =  iTodoService.findbyid(id);
        if(todoDTO1==null)
        {
            return Response.status(404).entity("Invalid Id").build();
        }
      //  todoDTO1 = new DozerBeanMapper().map(todoDTO, TodoDTO.class);
        iTodoService.update(todoDTO1);
        return Response.ok(todoDTO1).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE )
    public Response delete(@PathVariable(value = "id") Long id)
    {
            iTodoService.delete(id);
            return Response.ok().build();
    }


}
