package com.example.jsf.web.action;

import com.example.jsf.models.Role;
import com.example.jsf.models.UserModel;
import com.example.jsf.service.UserService;
import com.example.jsf.utils.SessionUtils;
import com.example.jsf.web.form.LoginForm;
import com.example.jsf.web.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@Component
@SessionScoped
@ManagedBean
public class RegisterFormAction implements Serializable {
    private final UserService userService;
    private final RegisterForm registerForm;

    public RegisterFormAction(
            @Autowired RegisterForm registerForm,
            @Autowired UserService userService
    ){
        this.registerForm = registerForm;
        this.userService = userService;
    }

    public String register(){
        try {
            userService.createNewUser(
                    new UserModel(
                            this.registerForm.getUsername(),
                            this.registerForm.getPassword(),
                            Role.USER
                    )
            );
            return "todo";
        } catch (IllegalAccessException e) {
            return "login";
        }
    }
}
