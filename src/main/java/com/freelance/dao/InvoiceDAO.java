package com.freelance.dao;

import com.freelance.model.Invoice;
import com.freelance.util.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InvoiceDAO {

    public void saveInvoice(Invoice invoice) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(invoice);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Invoice getInvoiceById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        Invoice invoice = session.get(Invoice.class, id);
        Hibernate.initialize(invoice.getServices()); // Force initialize while session is open
        return invoice;
    }
    }

    public List<Invoice> getAllInvoices() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Invoice", Invoice.class).list();
        }
    }
}
