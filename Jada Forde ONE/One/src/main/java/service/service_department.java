package service;

import models.department;

import java.util.List;

public interface service_department {
    public department getDepartment(int id);

    public List<department> getAllDepartment();

    public department addDepartment(department a);

    public department updateDepartment(department change);

    public department deleteDepartment(int id);
}
