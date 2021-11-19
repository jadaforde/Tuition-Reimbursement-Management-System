package controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import models.event;
import service.service_event;

import java.util.List;

public class ctr_event {
    Gson gson = new Gson();
    service_event se;

    public ctr_event(service_event se) {
        this.se = se;
    }

    public Handler getAllEvent = (ctx) -> {
        List<event> eList = se.getAllEvent();

        ctx.result(gson.toJson(eList));
    };


    public Handler getEvent = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }

        event a = se.getEvent(id);

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.status(400);
        }
    };

    public Handler addEvent = (context) -> {
        event a = gson.fromJson(context.body(), event.class);

        a = se.addEvent(a);

        context.result((a != null) ? gson.toJson(a) : "{}");

    };

    public Handler updateEvent = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        event a = gson.fromJson(context.body(), event.class);

        a.setEvent_id(id);

        a = se.updateEvent(a);
        context.result((a != null) ? gson.toJson(a) : "{}");
    };


    public Handler deleteEvent = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        event a = se.deleteEvent(id);

        ctx.result((a != null) ? gson.toJson(a) : "{}");
    };


}
