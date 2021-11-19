package repository;

import connection.Hibernate;
import logging.Mylogger;
import models.employee;
import models.form;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class rim_form implements repo_form{

    public form getForm(int id) {
        Session session = Hibernate.getSession();
        form a = null;

        try {
            a = session.get(form.class, id);
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }



    public List<form> getAllForm() {

        Session session = Hibernate.getSession();
        List<form> forms = null;

        try {
            forms = session.createQuery("FROM form").list();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return forms;
    }


    public form addForm(form a) {
        Session session = Hibernate.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            a.setForm_id((int)session.save(a));
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



    public form updateForm(form change) {
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



}
