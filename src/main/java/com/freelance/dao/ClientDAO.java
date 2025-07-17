package com.freelance.dao;

import com.freelance.model.Client;
import com.freelance.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDAO {

    public void saveClient(Client client) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Client> getAllClients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}
