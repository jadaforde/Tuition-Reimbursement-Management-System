package repository;

import models.form;

import java.util.List;

public interface repo_form {

    public form getForm(int id);
    public List<form> getAllForm();
    public form addForm(form a);
    public form updateForm(form change);


}
