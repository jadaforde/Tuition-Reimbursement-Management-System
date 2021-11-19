package repository;

import connection.Hibernate;
import logging.Mylogger;
import models.grade;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class rim_grade implements repo_grade{
    public grade getGrade(int id) {
        Session session = Hibernate.getSession();
        grade a = null;

        try {
            a = session.get(grade.class, id);
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }


    public List<grade> getAllGrade() {
        Session session = Hibernate.getSession();
        List<grade> grades = null;

        try {
            grades = session.createQuery("FROM grade").list();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return grades;
    }


    public grade addGrade(grade a) {
        Session session = Hibernate.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            a.setGrade_id((int)session.save(a));
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


    public grade updateGrade(grade change) {
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


    public grade deleteGrade(int id) {
        Session session = Hibernate.getSession();
        Transaction tx = null;
        grade a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(grade.class, id);
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
