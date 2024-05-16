package com.example.jsf.beans;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@ManagedBean
public class TempDataBean {
    private String editData;

    public String getEditData() {
        return editData;
    }

    public void setEditData(String editData) {
        this.editData = editData;
    }
}

