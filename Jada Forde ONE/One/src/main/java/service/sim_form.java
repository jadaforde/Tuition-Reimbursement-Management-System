package service;

import models.employee;
import models.form;
import repository.repo_form;

import java.util.ArrayList;
import java.util.List;

public class sim_form implements service_form {

    repo_form sf;
    sim_employee se;

    public sim_form(repo_form sf, sim_employee se) {
        this.sf = sf;
        this.se = se;
    }

//    public sim_form(repo_form f) {
//    }

    public form getForm(int id) {
        return sf.getForm(id);
    }

    public List<form> getAllForm() {
        return sf.getAllForm();
    }


    public form addForm(form a) {
        return sf.addForm(a);
    }

    public form updateForm(form change) {
        return sf.updateForm(change);
    }


    public List<form> getAccess(int id) {

        List<form> aList = new ArrayList<>();
        List<form> superV = new ArrayList<>();
        List<form> departH = new ArrayList<>();
        List<form> benCo = new ArrayList<>();
        List<form> employ = new ArrayList<>();

        List<form> current = sf.getAllForm();


        if(superV != null){
            aList.addAll(superV);
        }
        if(departH != null){
            aList.addAll(departH);
        }
        if(benCo != null){
            aList.addAll(benCo);
        }
        if(employ != null){
            aList.addAll(employ);
        }


                  return aList;
                }


    }

