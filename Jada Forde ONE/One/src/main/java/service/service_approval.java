package service;

import models.approval;
import models.department;

import java.util.List;

public interface service_approval {
    public List<approval> getAllApproval();
    public approval updateApproval(approval change);
    public approval getApproval(int id);
    public approval currentC(int diff);
    public approval addApproval(approval a);
}
