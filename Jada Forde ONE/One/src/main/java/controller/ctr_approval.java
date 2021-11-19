package controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import io.javalin.http.Context;
import logging.Mylogger;
import models.approval;
import models.department;
import models.employee;
import service.service_approval;
import service.service_employee;

import java.util.List;

public class ctr_approval {
    Gson gson = new Gson();
    service_approval a;

    public ctr_approval(service_approval a) {
        this.a = a;
    }

    public Handler getApproval = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
            approval c= a.getApproval(id);
        } catch (NumberFormatException e) {
            id = -1;
        }
      //  approval c = a.getApproval(id);

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.status(400);
        }
    };

    public Handler getAllApproval = (ctx) -> {
        List<approval> aList = a.getAllApproval();

        ctx.result(gson.toJson(aList));
    };

    public Handler updateApproval = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        approval f = gson.fromJson(context.body(), approval.class);

        f.setApp_id(id);

        f = a.updateApproval(f);
        context.result((f != null) ? gson.toJson(f) : "{}");
    };


    public Handler currentC=context -> {
        int id = Integer.parseInt(context.pathParam("id"));
        approval CD= a.currentC(id);
        populateResult(context,CD);

    };

    private void populateResult(Context context, approval a) {

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.result("{}");
        }

    }
    public Handler addApproval = (context) -> {
        approval ab = gson.fromJson(context.body(), approval.class);

        ab = a.addApproval(ab);

        context.result((ab != null) ? gson.toJson(ab) : "{}");

    };


}
