package com.example.jsf.service;


import com.example.jsf.models.TodoModel;
import com.example.jsf.models.UserModel;
import com.example.jsf.repository.TodoRepository;
import com.example.jsf.repository.UserRepository;
import com.example.jsf.utils.SessionUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;

    public List<TodoModel> getAllTodos(){
        return todoRepository.findAll();
    }

    public void deleteTodo(Long id){
        System.out.println(id);
        todoRepository.deleteById(id);
        System.out.println(todoRepository.findAll());
    }

    public String addTodo(String todoData){
        UserModel user;
        try{
            String username = SessionUtils.getSession().getAttribute("username").toString();
            user = userService.getCurrentUser(username);

        }catch (UsernameNotFoundException e){
            return "login";
         }
        TodoModel todo = new TodoModel();

        todo.setUserModel(user);
        todo.setTodoItem(todoData);
        TodoModel todoModel = todoRepository.save(todo);
        System.out.println(todoRepository.findAll());

        return "todo";
    }
}
