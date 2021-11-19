package controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import logging.Mylogger;
import models.employee;
import models.form;
import service.service_employee;


import java.util.List;

public class ctr_employee {
    Gson gson = new Gson();
    service_employee se;

    public ctr_employee(service_employee se) {
        this.se = se;
    }


    public Handler updateEmployee = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        employee a = gson.fromJson(context.body(), employee.class);

        a.setE_id(id);

        a = se.updateEmployee(a);
        context.result((a != null) ? gson.toJson(a) : "{}");
    };

    public Handler addEmployee = (context) -> {
        employee a = gson.fromJson(context.body(), employee.class);

        a = se.addEmployee(a);

        context.result((a != null) ? gson.toJson(a) : "{}");

    };

    public Handler getEmployee = (context) -> {
        String input = context.pathParam("id");
        int id;
        Mylogger.logger.info("We got here 1");

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }
        employee a = se.getEmployee(id);
        Mylogger.logger.info("We got here 2");

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            Mylogger.logger.info("We got here 3");
            context.status(400);
        }
    };

    public Handler getAllEmployee = (ctx) -> {
        List<employee> eList = se.getAllEmployee();

        ctx.result(gson.toJson(eList));
    };

    public Handler login = (ctx) -> {
        String str = ctx.header("Authorization");
        String[] login = str.split(":", 2);
         employee a = new employee();
         a.setUsername(login[0]);
         a.setPassword(login[1]);
         a = se.login(a.getUsername(), a.getPassword());
         if (a != null){
             ctx.result(gson.toJson(a));
             ctx.status(200);
         }else
         {
             ctx.status(205);
         }

    };

//    public Handler getLoginINFO=(context)-> {
//        String user = context.pathParam("user");
//        String password= context.pathParam("password");
//        List<login> loginList= oner.getAllLogin();
//
//        if(loginList != null)
//        {        System.out.println(" if statment  woe "+usero+password);
//
//            for(login b:loginList)
//            {
//                if (b.getUsername().equals(usero) && b.getPassword().equals(password))
//                {
//                    oner.getById(b.getId());
//                    System.out.println(b.getId());
//                    context.result(gson.toJson(b));
//                }
//            }
//            context.status(200);
//        }
//        context.status(205);
//
//    };




    public Handler getAllForm = (ctx) -> {
        List<form> fList = se.getAllForm();

        ctx.result(gson.toJson(fList));
    };


    public Handler getForm = (context) -> {
        String input = context.pathParam("id");
        int id;

        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            id = -1;
        }

        form a = se.getForm(id);

        if(a != null) {
            context.result(gson.toJson(a));
        } else {
            context.status(400);
        }
    };

    public Handler addForm = (context) -> {
//        String body = context.body();

        form a = gson.fromJson(context.body(), form.class);

        a = se.addForm(a);

        context.result((a != null) ? gson.toJson(a) : "{}" );

    };

    public Handler updateForm = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        form a = gson.fromJson(context.body(), form.class);
        Mylogger.logger.info(a);
        System.out.print(a);
        a.setForm_id(id);

        a = se.updateForm(a);
        context.result((a != null) ? gson.toJson(a) : "{}");
    };





}
