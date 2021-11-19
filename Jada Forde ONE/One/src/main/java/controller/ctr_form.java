package controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.event;
import models.form;
import models.grade;
import service.service_event;
import service.service_form;

import java.util.List;

public class ctr_form {
    Gson gson = new Gson();
    service_form sf;

    public ctr_form(service_form sf) {
        this.sf = sf;
    }
    public Handler getAllForm = (ctx) -> {
        List<form> fList = sf.getAllForm();

        ctx.result(gson.toJson(fList));
    };

//    public Handler getAccess = (context) -> {
//        String input = context.pathParam("id");
//        int id;
//        try {
//            id = Integer.parseInt(input);
//        } catch (NumberFormatException e) {
//            id = -1;
//        }

//        List<form> aList = sf.getAccess(id);
//
//        if(aList != null) {
//            context.result(gson.toJson(aList));
//        } else {
//            context.status(400);
//        }
//    };

//        public Handler getAccess = (context) -> {
//            String input = context.pathParam("id");
//            int id;
//            try {
//                id = Integer.parseInt(input);
//            } catch (NumberFormatException e) {
//                id = -1;
//            }
//            List<form> aList = sf.getAccess(id);
//            context.result(gson.toJson(aList));
//
//        };

    public Handler getForm = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }

        form a = sf.getForm(id);

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.status(400);
        }
    };

    public Handler addForm = (context) -> {
        form a = gson.fromJson(context.body(), form.class);

        a = sf.addForm(a);

        context.result((a != null) ? gson.toJson(a) : "{}");

    };

    public Handler updateForm = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        form a = gson.fromJson(context.body(), form.class);

        a.setForm_id(id);

        a = sf.updateForm(a);
        context.result((a != null) ? gson.toJson(a) : "{}");
    };





}
