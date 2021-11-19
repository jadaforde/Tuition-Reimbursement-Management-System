package repository;

import models.grade;

import java.util.List;

public interface repo_grade {

    public grade getGrade(int id);
    public List<grade> getAllGrade();
    public grade addGrade(grade a);
    public grade updateGrade(grade change);
    public grade deleteGrade(int id);

}
