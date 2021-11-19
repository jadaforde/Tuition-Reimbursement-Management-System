package repository;

import connection.Hibernate;
import logging.Mylogger;
import models.approval;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class rim_approval implements repo_approval{
    @Override
    public approval getApproval(int id) {
        Session session = Hibernate.getSession();
        approval a = null;
//
//        try {
//            a = session.get(approval.class, id);
//        } catch (HibernateException e) {
//            Mylogger.logger.debug(e.getMessage());
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }

        return a;
    }


    @Override
    public List<approval> getAllApproval() {
        Session session = Hibernate.getSession();
        List<approval> app = null;

        try {
            app = session.createQuery("FROM approval").list();
        } catch (HibernateException e) {
            Mylogger.logger.debug(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }

        return app;
    }


    @Override
    public approval updateApproval(approval change) {
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

    @Override
    public approval currentC(int diff) {
        Session session = Hibernate.getSession();
        approval one = null;
        try {
            one= session.get(approval.class, diff);
        }catch (HibernateException a)
        {
            a.printStackTrace();
        }finally {
            session.close();
        }
        return one;
    }

    @Override
    public approval addApproval(approval a) {
        Session session = Hibernate.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            a.setApp_id((int)session.save(a));
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
