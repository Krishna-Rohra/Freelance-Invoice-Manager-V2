package com.freelance;

import com.freelance.dao.ClientDAO;
import com.freelance.dao.ServiceDAO;
import com.freelance.dao.InvoiceDAO;
import com.freelance.model.Client;
import com.freelance.model.Service;
import com.freelance.model.Invoice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();
        ServiceDAO serviceDAO = new ServiceDAO();
        InvoiceDAO invoiceDAO = new InvoiceDAO();

        Client client = new Client("Alice", "alice@example.com");
        clientDAO.saveClient(client);

        Service s1 = new Service("Logo Design", 1200.0);
        Service s2 = new Service("Website Setup", 2500.0);
        serviceDAO.saveService(s1);
        serviceDAO.saveService(s2);

        Set<Service> services = new HashSet<>(Arrays.asList(s1, s2));
        Invoice invoice = new Invoice(client, services, s1.getPrice() + s2.getPrice());
        invoiceDAO.saveInvoice(invoice);

        Invoice fetched = invoiceDAO.getInvoiceById(invoice.getId());
        System.out.println("Invoice for: " + fetched.getClient().getName());
        System.out.println("Total: ₹" + fetched.getTotal());
        System.out.println("Services:");
        for (Service s : fetched.getServices()) {
            System.out.println("- " + s.getDescription() + " ₹" + s.getPrice());
        }
    }
}
