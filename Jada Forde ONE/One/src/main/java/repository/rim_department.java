package repository;

import connection.Hibernate;
import logging.Mylogger;
import models.department;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class rim_department implements repo_department{
    public department getDepartment(int id) {
        Session session = Hibernate.getSession();
        department a = null;

        try {
            a = session.get(department.class, id);
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }



    public List<department> getAllDepartment() {
        Session session = Hibernate.getSession();
        List<department> depart = null;

        try {
            depart = session.createQuery("FROM department").list();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return depart;
    }


    public department addDepartment(department a) {
        Session session = Hibernate.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            a.setD_id((int)session.save(a));
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


    public department updateDepartment(department change) {
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



    public department deleteDepartment(int id) {

        Session session = Hibernate.getSession();
        Transaction tx = null;
        department a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(department.class, id);
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
