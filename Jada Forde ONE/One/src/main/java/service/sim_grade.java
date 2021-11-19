package service;

import models.grade;
import repository.repo_grade;

import java.util.List;

public class sim_grade implements service_grade{
    repo_grade sg;

    public sim_grade(repo_grade sg) {
        this.sg = sg;
    }

    @Override
    public grade getGrade(int id) {
        return sg.getGrade(id);
    }

    @Override
    public List<grade> getAllGrade() {
        return sg.getAllGrade();
    }

    @Override
    public grade addGrade(grade a) {
        return sg.addGrade(a);
    }

    @Override
    public grade updateGrade(grade change) {
        return sg.updateGrade(change);
    }

    @Override
    public grade deleteGrade(int id) {
        return sg.deleteGrade(id);
    }
}
