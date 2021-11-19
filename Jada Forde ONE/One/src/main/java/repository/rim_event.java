package repository;

import connection.Hibernate;
import logging.Mylogger;
import models.event;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class rim_event implements repo_event{
    public event getEvent(int id) {
        Session session = Hibernate.getSession();
        event a = null;

        try {
            a = session.get(event.class, id);
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    public List<event> getAllEvent() {
        Session session = Hibernate.getSession();
        List<event> events = null;

        try {
            events = session.createQuery("FROM event").list();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return events;
    }



    public event addEvent(event a) {

        Session session = Hibernate.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            a.setEvent_id((int)session.save(a));
            tx.commit();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return a;
    }


    public event updateEvent(event change) {
        Session session = Hibernate.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(change);
            tx.commit();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
            tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return change;
    }


    public event deleteEvent(int id) {
        Session session = Hibernate.getSession();
        Transaction tx = null;
        event a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(event.class, id);
            session.delete(a);
            tx.commit();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return a;
    }

}
