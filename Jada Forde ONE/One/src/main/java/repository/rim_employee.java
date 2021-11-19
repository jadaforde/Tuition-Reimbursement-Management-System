package repository;

import connection.Hibernate;
import logging.Mylogger;
import models.employee;
import models.form;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import org.hibernate.query.Query;
import java.util.List;

public class rim_employee implements repo_employee{
    public employee getEmployee(int id) {
        Session session = Hibernate.getSession();
        employee a = null;

        try {
            Mylogger.logger.info("We got here 1");
            a = session.get(employee.class, id);
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }



    public List<employee> getAllEmployee() {

        Session session = Hibernate.getSession();
        List<employee> empl = null;

        try {
            empl = session.createQuery("FROM employee").list();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return empl;
    }



    public employee addEmployee(employee a) {
        Session session = Hibernate.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            a.setE_id((int)session.save(a));
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


    public employee updateEmployee(employee change) {
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



        public employee deleteEmployee(int id) {
        Session session = Hibernate.getSession();
        Transaction tx = null;
        employee a = null;

        try {
            tx = session.beginTransaction();
            a = session.get(employee.class, id);
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


    public employee login(String username, String password) {
        Session session = Hibernate.getSession();
        employee a = null;

        String hql = "FROM employee WHERE username = :user AND password = :pword";

        try {
            Query query = session.createQuery(hql);
            query.setParameter("user", username);
            query.setParameter("pword", password);
            List results = query.list();
            if (results.size() >0){
                a = (employee) results.get(0);
            }

        }catch (HibernateException e){
             e.printStackTrace();
        }finally {
            session.close();
        }
         return a;


    }
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
