package repository;

import models.event;

import java.util.List;

public interface repo_event {

    public event getEvent(int id);
    public List<event> getAllEvent();
    public event addEvent(event a);
    public event updateEvent(event change);
    public event deleteEvent(int id);

}
