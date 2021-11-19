package repository;

import models.approval;
import models.department;

import java.util.List;

public interface repo_approval {

    public approval getApproval(int id);
    public List<approval> getAllApproval();
    public approval updateApproval(approval change);
    public approval currentC(int diff);
    public approval addApproval(approval a);



}
