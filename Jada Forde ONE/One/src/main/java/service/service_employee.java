package service;

import models.department;
import models.employee;
import models.form;

import java.util.List;

public interface service_employee {
    public employee getEmployee(int id);

    public List<employee> getAllEmployee();

    public employee addEmployee(employee a);

    public employee updateEmployee(employee change);

    public employee deleteEmployee(int id);

    public employee login(String username, String password);

    public form getForm(int id);

    public List<form> getAllForm();

    public form addForm(form a);

    public form updateForm(form change);

//    public List<form> getAccess(int id);

    //public List<employee> getCred(int id);

}
