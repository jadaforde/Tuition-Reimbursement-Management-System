package service;

import models.approval;
import models.department;
import repository.repo_approval;
import repository.rim_approval;

import java.util.List;

public class sim_approval implements service_approval{

    repo_approval rs = new rim_approval();

    public sim_approval(repo_approval rs) {
        this.rs = rs;
    }

    public List<approval> getAllApproval() {
        return rs.getAllApproval();
    }

    @Override
    public approval updateApproval(approval change) {
        return rs.updateApproval(change);
    }

    @Override
    public approval getApproval(int id) {
        return rs.getApproval(id);
    }

    @Override
    public approval currentC(int diff) {
        return rs.currentC(diff);
    }


    public approval addApproval(approval a) {
        return rs.addApproval(a);
    }
}
