package com.example.jsf.web.action;


import com.example.jsf.models.TodoModel;
import com.example.jsf.service.TodoService;
import com.example.jsf.web.form.EditTodoForm;
import com.example.jsf.web.form.ToDoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.List;

@Component
@SessionScoped
@ManagedBean
public class ToDoPageAction implements Serializable {
    private final ToDoPage toDoPage;
    private final TodoService todoService;
    private final EditTodoForm editTodoForm;


    public ToDoPageAction(
            @Autowired ToDoPage toDoPage,
            @Autowired  TodoService todoService,
            @Autowired EditTodoForm editTodoForm) {
        this.toDoPage = toDoPage;
        this.todoService = todoService;
        this.editTodoForm = editTodoForm;
    }

    public void logNewTodoItem(){
        todoService.addTodo(this.toDoPage.getNewTodo());
    }

    public String deleteTodo(Long id){
        todoService.deleteTodo(id);
        return "todo";
    }

    public String editTodo(Long id,String data){
        System.out.println("Data:   "+ data);
        todoService.editTodoById(id, "data");
        return "todo";
    }

    public String editTodoRedirect(Long id){
        System.out.println("Redirect:  "+id);
        return "edit?faces-redirect=true&todoId=" + id;
    }



    public List getAll(){
        this.toDoPage.setTodos(todoService.getAllTodos());
        return todoService.getAllTodos();
    }
}
