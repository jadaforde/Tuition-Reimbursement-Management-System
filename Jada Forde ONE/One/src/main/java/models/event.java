package models;

import javax.persistence.*;

@Entity
@Table( name= "event", schema = "public")
public class event {
    @Id
    @Column(name = "event_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    @Column(name = "event_t")
    private String event_t;

    public event() {
    }

    public event(String event_t) {
        this.event_t = event_t;
    }

    public event(int event_id, String event_t) {
        this.event_id = event_id;
        this.event_t = event_t;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_t() {
        return event_t;
    }

    public void setEvent_t(String event_t) {
        this.event_t = event_t;
    }

    @Override
    public String toString() {
        return "event{" +
                "event_id=" + event_id +
                ", event_t='" + event_t + '\'' +
                '}';
    }
}
