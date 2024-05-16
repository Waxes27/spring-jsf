package com.example.jsf.web.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Component
@SessionScoped
@ManagedBean
@Getter
@Setter
public class RegisterForm implements Serializable {
    private String username;
    private String password;
}
