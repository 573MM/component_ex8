package entitymanagerdemo2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class CustomerTable {
     public static void insertCustomer(Customer emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateCustomer(Customer o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        Customer fromDb = em.find(Customer.class, o.getId());
        fromDb.setFirstname(o.getFirstname());
        fromDb.setLastname(o.getLastname());
        fromDb.setEmail(o.getEmail());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static Customer findCustomerById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        Customer c = em.find(Customer.class, id);
        em.close();
        return c;
    }
    public static List<Customer> findAllCustomer() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        List<Customer> empList = (List<Customer>) em.createNamedQuery("Customer.findAll").getResultList();
        em.close();
        return empList;
    }
    public static List<Customer> findCustomerByFirstname(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Customer.findByFirstname");
        query.setParameter("name", name);
        List<Customer> empList = (List<Customer>) query.getResultList();
        em.close();
        return empList;
    }
    public static void removeCustomer(Customer o) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        Customer fromDb = em.find(Customer.class, o.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
}
