package com.freelance.dao;

import com.freelance.model.Service;
import com.freelance.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ServiceDAO {

    public void saveService(Service service) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(service);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Service> getAllServices() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Service", Service.class).list();
        }
    }
}
