package com.example.jsf.web.form;


import com.example.jsf.models.TodoModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Component
@SessionScoped
@ManagedBean
@Getter
@Setter
public class ToDoPage {
    private String username;
    private String role;
    private String newTodo = "";
    private List<TodoModel> todos;
    private static String editTodoData;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNewTodo() {
        return newTodo;
    }

    public void setNewTodo(String newTodo) {
        this.newTodo = newTodo;
    }

    public List<TodoModel> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoModel> todos) {
        this.todos = todos;
    }

    public static String getEditTodoData() {
        return editTodoData;
    }

    public static void setEditTodoData(String editTodoData) {
        ToDoPage.editTodoData = editTodoData;
    }
}
