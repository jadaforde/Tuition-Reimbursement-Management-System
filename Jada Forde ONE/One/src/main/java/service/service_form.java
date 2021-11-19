package service;

import models.event;
import models.form;

import java.util.List;

public interface service_form {
    public form getForm(int id);

    public List<form> getAllForm();

    public form addForm(form a);

    public form updateForm(form change);

//    public List<form> getAccess(int id);

    //public List<form> getAllFormById(int id);


//    public form Amount(form a);
}
