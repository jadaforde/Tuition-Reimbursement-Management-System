package app;

import controller.*;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import repository.*;
import service.*;

import java.util.logging.Handler;


public class hiber {
    public hiber() {
    }

    public static void main(String[] args) {
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        establishRoutes(app);
        app.start(7001);

    }

    private static void establishRoutes(Javalin app) {

        //EMPLOYEE
        repo_employee re = new rim_employee();
        service_employee se = new sim_employee(re);
        ctr_employee b = new ctr_employee(se);


        app.get("/employeelogin", b.login);
        app.get("/employee/:id", b.getEmployee);
        app.get("/employee", b.getAllEmployee);
        app.post("/form/:id", b.addForm);
        app.get("/form", b.getAllForm);
        app.post("/form", b.updateForm);
        app.get("/form/:id", b.getForm);
//        app.get("/access/:id", b.getAccess);



        //GRADE
        repo_grade rg = new rim_grade();
        service_grade sg = new sim_grade(rg);
        ctr_grade c = new ctr_grade(sg);

        app.get("/grade/:id", c.getGrade);
        app.post("/grade/id", c.addGrade);
        app.delete("/grade/id", c.deleteGrade);

        //EVENT
        repo_event rs = new rim_event();
        service_event s = new sim_event(rs);
        ctr_event cl = new ctr_event(s);

        app.get("/event", cl.getAllEvent);
        app.post("/event/id", cl.addEvent);




        //FORM
//        repo_form f = new rim_form();
//        service_form g = new sim_form(f);
//        ctr_form d = new ctr_form(g);


//        app.post("/form/:id", d.addForm);
//        app.get("/form", d.getAllForm);
//        app.post("/form", d.updateForm);
//        app.get("/form/:id", d.getForm);
//        app.get("/access/:id", d.getAccess);



        //APPROVAL
        repo_approval x = new rim_approval();
        service_approval y = new sim_approval(x);
        ctr_approval z = new ctr_approval(y);


        app.get("/approval", z.getAllApproval);
        app.get("/approval/:id", z.currentC);
        app.patch("/approval/:id", z.updateApproval);
        app.post("/approval/:id", z.addApproval);





    }
}
