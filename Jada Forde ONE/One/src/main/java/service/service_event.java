package service;

import models.department;
import models.event;
import models.form;

import java.util.List;

public interface service_event {
    public event getEvent(int id);

    public List<event> getAllEvent();

    public event addEvent(event a);

    public event updateEvent(event change);

    public event deleteEvent(int id);

}
