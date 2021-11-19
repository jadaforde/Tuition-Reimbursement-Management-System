package controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;

import models.grade;

import service.service_grade;

import java.util.List;

public class ctr_grade {
    Gson gson = new Gson();
    service_grade sg;

    public ctr_grade(service_grade sg) {
        this.sg = sg;
    }



    public Handler getAllGrade = (ctx) -> {
        List<grade> gList = sg.getAllGrade();

        ctx.result(gson.toJson(gList));
    };

    public Handler getGrade = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }

        grade a = sg.getGrade(id);

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.status(400);
        }
    };

    public Handler addGrade = (context) -> {
        grade a = gson.fromJson(context.body(), grade.class);

        a = sg.addGrade(a);

        context.result((a != null) ? gson.toJson(a) : "{}");

    };

    public Handler updateGrade = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        grade a = gson.fromJson(context.body(), grade.class);

        a.setGrade_id(id);

        a = sg.updateGrade(a);
        context.result((a != null) ? gson.toJson(a) : "{}");
    };

    public Handler deleteGrade = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        grade a = sg.deleteGrade(id);

        ctx.result((a != null) ? gson.toJson(a) : "{}");
    };
}
