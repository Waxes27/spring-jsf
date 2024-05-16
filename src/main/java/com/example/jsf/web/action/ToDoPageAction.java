package com.example.jsf.web.action;


import com.example.jsf.service.TodoService;
import com.example.jsf.web.form.ToDoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Component
@SessionScoped
@ManagedBean
public class ToDoPageAction implements Serializable {
    private final ToDoPage toDoPage;
    private final TodoService todoService;


    public ToDoPageAction(@Autowired ToDoPage toDoPage, @Autowired  TodoService todoService) {
        this.toDoPage = toDoPage;
        this.todoService = todoService;
    }

    public void logNewTodoItem(){
        todoService.addTodo(toDoPage.getNewTodo());
        toDoPage.setNewTodo(" ");

    }

    public String deleteTodo(Long id){
        todoService.deleteTodo(id);
        return "todo";
    }

    public List getAll(){
        this.toDoPage.setTodos(todoService.getAllTodos());
        return todoService.getAllTodos();
    }
}
