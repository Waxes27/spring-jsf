package com.example.jsf.web.action;

import com.example.jsf.models.Role;
import com.example.jsf.models.UserModel;
import com.example.jsf.service.UserService;
import com.example.jsf.utils.SessionUtils;
import com.example.jsf.web.form.LoginForm;
import com.example.jsf.web.form.ToDoPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@Component
@SessionScoped
@ManagedBean
public class LoginFormAction implements Serializable {
    private final UserService userService;
    private final LoginForm loginForm;
    private final ToDoPage toDoPage;

    public LoginFormAction(
            @Autowired LoginForm loginForm,
            @Autowired UserService userService,
            @Autowired ToDoPage toDoPage
    ){
        this.loginForm = loginForm;
        this.userService = userService;
        this.toDoPage = toDoPage;
    }

    public String login() throws IllegalAccessException {
        System.out.println(this.loginForm.getUsername());
        UserDetails user;
        try {
            user = userService.loadUserByUsername(this.loginForm.getUsername());

        } catch (UsernameNotFoundException e){
            user =userService.createNewUser(
                    new UserModel(
                            this.loginForm.getUsername(),
                            this.loginForm.getPassword(),
                            Role.USER
                    ));
        }
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("username", user.getUsername());
        toDoPage.setUsername(user.getUsername());
        return "todo";
    }
}
