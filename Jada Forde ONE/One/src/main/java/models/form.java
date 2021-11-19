package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="form", schema = "public")
public class form {

    @Id
    @Column(name= "form_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int form_id;

    @Column(name="date")
    private long date;

    @Column(name="description")
    private String description;

    @Column(name="cost")
    private int cost;

    @Column(name="location")
    private String location;





    @JoinColumn(name="e_id")
    private int e_id;

    @Column(name="event_id")
    private int event_id;


    @Column(name="grade_id")
    private int grade_id;

    @Column(name="approval")
    private int app_id;



    public form() {
    }

    public form(long date, String description, int cost, String location, int e_id, int event_id, int grade_id, int app_id) {
        this.date = date;
        this.description = description;
        this.cost = cost;
        this.location = location;
        this.e_id = e_id;
        this.event_id = event_id;
        this.grade_id = grade_id;
        this.app_id = app_id;
    }

    public form(int form_id, long date, String description, int cost, String location, int e_id, int event_id, int grade_id, int app_id) {
        this.form_id = form_id;
        this.date = date;
        this.description = description;
        this.cost = cost;
        this.location = location;
        this.e_id = e_id;
        this.event_id = event_id;
        this.grade_id = grade_id;
        this.app_id = app_id;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof form)) return false;
        form form = (form) o;
        return form_id == form.form_id && date == form.date && cost == form.cost && e_id == form.e_id && event_id == form.event_id && grade_id == form.grade_id && app_id == form.app_id && Objects.equals(description, form.description) && Objects.equals(location, form.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(form_id, date, description, cost, location, e_id, event_id, grade_id, app_id);
    }

    @Override
    public String toString() {
        return "form{" +
                "form_id=" + form_id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", location='" + location + '\'' +
                ", e_id=" + e_id +
                ", event_id=" + event_id +
                ", grade_id=" + grade_id +
                ", app_id=" + app_id +
                '}';
    }
}

