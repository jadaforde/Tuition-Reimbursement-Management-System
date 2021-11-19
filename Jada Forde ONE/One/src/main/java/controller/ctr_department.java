package controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.department;
import models.grade;
import service.service_department;
import service.service_event;

import java.util.List;

public class ctr_department {
    Gson gson = new Gson();
    service_department sd;

    public ctr_department(service_department sd) {
        this.sd = sd;
    }

    public Handler getAllDepartment = (ctx) -> {
        List<department> dList = sd.getAllDepartment();

        ctx.result(gson.toJson(dList));
    };


    public Handler getDepartment = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }

        department a = sd.getDepartment(id);

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.status(400);
        }
    };

    public Handler addDepartment = (context) -> {
        department a = gson.fromJson(context.body(), department.class);

        a = sd.addDepartment(a);

        context.result((a != null) ? gson.toJson(a) : "{}");

    };

    public Handler updateDepartment = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        department a = gson.fromJson(context.body(), department.class);

        a.setD_id(id);

        a = sd.updateDepartment(a);
        context.result((a != null) ? gson.toJson(a) : "{}");
    };

    public Handler deleteDepartment = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        department a = sd.deleteDepartment(id);

        ctx.result((a != null) ? gson.toJson(a) : "{}");
    };





}
