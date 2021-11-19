package service;

import models.department;
import repository.repo_department;

import java.util.List;

public class sim_department implements service_department{
    repo_department sd;

    public sim_department(repo_department sd) {
        this.sd = sd;
    }

    public department getDepartment(int id) {
        return sd.getDepartment(id);
    }

    public List<department> getAllDepartment() {
        return sd.getAllDepartment();
    }

    public department addDepartment(department a) {
        return sd.addDepartment(a);
    }

    public department updateDepartment(department change) {
        return sd.updateDepartment(change);
    }

    public department deleteDepartment(int id) {
        return sd.deleteDepartment(id);
    }
}
