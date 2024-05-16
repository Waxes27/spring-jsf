package com.example.jsf.web.form;
import com.example.jsf.utils.SessionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@RequestScoped
@ManagedBean
public class EditTodoForm implements Serializable {
    @ManagedProperty(value = "#{param.todoId}")
    private Long todoId;
    private String dataToEdit;

    @PostConstruct
    public void init() {

        String id = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("todoId");
        // Access todoId here
        System.out.println(id);

        if (id != null){
            this.setTodoId(Long.valueOf(id));
        }
//        int counter = 0;
//        while (id == null){
//            System.out.println("Post");
//            String tempId = FacesContext.getCurrentInstance()
//                    .getExternalContext().getRequestParameterMap().get("todoId");
//            if (tempId != null){
//                this.todoId = Long.valueOf(tempId);
//            };
//
//            if(counter == 20){
//                break;}
//            counter++;
//        }
        ;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
        this.todoId = todoId;
    }

    public String getDataToEdit() {
        return dataToEdit;
    }

    public void setDataToEdit(String dataToEdit) {
        this.dataToEdit = dataToEdit;
    }
}
