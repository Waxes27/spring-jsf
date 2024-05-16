package com.example.jsf.web.form;


import com.example.jsf.models.TodoModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
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
}
