package service;

import models.event;
import repository.repo_event;

import java.util.List;

public class sim_event implements service_event {
    repo_event se;

    public sim_event(repo_event se) {
        this.se = se;
    }

    public event getEvent(int id) {
        return se.getEvent(id);
    }

    public List<event> getAllEvent() {
        return se.getAllEvent();
    }

    public event addEvent(event a) {
        return se.addEvent(a);
    }

    public event updateEvent(event change) {
        return se.updateEvent(change);
    }

    public event deleteEvent(int id) {
        return se.deleteEvent(id);
    }
}
