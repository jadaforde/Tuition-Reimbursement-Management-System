package repository;

import models.employee;
import models.form;

import java.util.List;

public interface repo_employee {

    public employee getEmployee(int id);
    public List<employee> getAllEmployee();
    public employee addEmployee(employee a);
    public employee updateEmployee(employee mod);
    public employee deleteEmployee(int id);
    public employee login(String username, String password);

    public form getForm(int id);
    public List<form> getAllForm();
    public form addForm(form a);
    public form updateForm(form change);
}
