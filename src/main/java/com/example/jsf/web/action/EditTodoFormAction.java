package com.example.jsf.web.action;


import com.example.jsf.service.TodoService;
import com.example.jsf.web.form.EditTodoForm;
import com.example.jsf.web.form.ToDoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Component
@RequestScoped
@ManagedBean
public class EditTodoFormAction implements Serializable {
    private final EditTodoForm editTodoForm;
    private final TodoService todoService;


    public EditTodoFormAction(@Autowired EditTodoForm toDoPage, @Autowired  TodoService todoService) {
        this.editTodoForm = toDoPage;
        this.todoService = todoService;
    }

    public String editTodo(Long id,String data){

        System.out.println(FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("todoId"));
        return todoService.editTodoById(id, data);
    }

}
