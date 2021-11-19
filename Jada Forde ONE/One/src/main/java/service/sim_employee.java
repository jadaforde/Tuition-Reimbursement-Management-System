package service;

import models.employee;
import models.form;
import repository.repo_employee;

import java.util.ArrayList;
import java.util.List;

public class sim_employee implements service_employee {
    repo_employee see;

    public sim_employee(repo_employee see) {
        this.see = see;
    }

    public employee getEmployee(int id) {
        return see.getEmployee(id);
    }

    public List<employee> getAllEmployee() {
        return see.getAllEmployee();
    }

    public employee addEmployee(employee a) {
        return see.addEmployee(a);
    }

    public employee updateEmployee(employee change) {
        return see.updateEmployee(change);
    }

    public employee deleteEmployee(int id) {
        return see.deleteEmployee(id);
    }

    public employee login(String username, String password) {
        return see.login(username, password);

    }

    public form getForm(int id) {
        return see.getForm(id);
    }

    public List<form> getAllForm() {
        return see.getAllForm();
    }

    public form addForm(form a) {
        return see.addForm(a);
    }

    public form updateForm(form change) {
        return see.updateForm(change);
    }


//    public List<form> getAccess(int id) {
//
//        List<form> aList = new ArrayList<>();
//        List<form> superV = new ArrayList<>();
//        List<form> departH = new ArrayList<>();
//        List<form> benCo = new ArrayList<>();
//        List<form> employ = new ArrayList<>();
//
//        List<form> current = see.getAllForm();
//        employee trace = see.getEmployee(id);
//
//        if (trace.getBenCo()) {
//            benCo.add(getForm(id));
//            aList.addAll(benCo);
//        } else if (trace.getSuper_id() == id) {
//            superV.add(getForm(id));
//            aList.addAll(superV);
//        } else if (trace.getD_id() == id) {
//            departH.add(getForm(id));
//            aList.addAll(departH);
//
//        } else {
//            employ.add(getForm(id));
//            aList.addAll(employ);
//        }
////
//        for (form i : current) {
//            if (i == aList.g)
//                return aList;
//        }
//        for (form i : current) {
//            if (i == superV.get(i.getForm_id()))
//                return aList;
//        }
//        for (form i : current) {
//            if (i == departH.get(i.getForm_id()))
//                return aList;
//        }
//        for (form i : current) {
//            if (i == employ.get(i.getForm_id()))
//                return aList;
//        }
//
//        return null;
//    }
}

