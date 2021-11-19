package connection;

import logging.Mylogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


    public class Hibernate {


        private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

        public static Session getSession() {
            Mylogger.logger.info("Started Session");
            return sf.openSession();
        }

    }


