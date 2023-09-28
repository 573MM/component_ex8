/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entitymanagerdemo2;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author LENOVO
 */
public class EntityManagerDemo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //createData();
        printAllCustomer();
        //printCustomerByCity("Bangkok");
        
        
    }

    /*public static void printAllCustomer(){
        List<Customer> employees = CustomerTable.findAllCustomer();
        System.out.println("All employee (by ID)");
        System.out.println("---------------------------");
        employees.forEach(empl -> {
            System.out.println("ID: " + empl.getEmployeeid());
            System.out.println("Name: " + empl.getName());
            System.out.println("Job: " + empl.getJob());
            System.out.println("Salary: " + empl.getSalary());
            System.out.println("Department: " + empl.getDepartmentid().getName());
            System.out.println("---------------------------");
        });
    }*/
    public static void printCustomerByCity(String city){
        System.out.println("---------------------------");
        List<Customer> customers = CustomerTable.findAllCustomer();
            //System.out.println(customers.toArray().length);
        System.out.println(city);
        for (int i = 0; i < customers.size(); i++){
                if(city.equals(customers.get(i).getAddressId().getCity())){
                    System.out.println("ID : " + customers.get(i).getId());
                    System.out.println("Firstname : " + customers.get(i).getFirstname());
                    System.out.println("Lastname : " + customers.get(i).getLastname());
                    System.out.println("Email : " + customers.get(i).getEmail());
                    System.out.println("Street : " + customers.get(i).getAddressId().getStreet());
                    System.out.println("City : " + customers.get(i).getAddressId().getCity());
                    System.out.println("Country : " + customers.get(i).getAddressId().getCountry());
                    System.out.println("Zip code : " + customers.get(i).getAddressId().getZipcode());
                    System.out.println("--------------------");
                    System.out.println();
                }
                
            
        }
    }
    public static void printAllCustomer() {
        System.out.println("--------------------");
        List<Customer> customers = CustomerTable.findAllCustomer();
        
        for(int i = 0; i < customers.size(); i++){
            System.out.println("ID : " + customers.get(i).getId());
            System.out.println("Firstname : " + customers.get(i).getFirstname());
            System.out.println("Lastname : " + customers.get(i).getLastname());
            System.out.println("Email : " + customers.get(i).getEmail());
            System.out.println("Street : " + customers.get(i).getAddressId().getStreet());
            System.out.println("City : " + customers.get(i).getAddressId().getCity());
            System.out.println("Country : " + customers.get(i).getAddressId().getCountry());
            System.out.println("Zip code : " + customers.get(i).getAddressId().getZipcode());
            System.out.println("--------------------");
            System.out.println();
        }
    }
    public static void createData(){
        Customer cu1 = new Customer(1L, "John", "Henry", "jh@mail.com");
        Customer cu2 = new Customer(2L, "Marry", "Jane", "mj@mail.com");
        Customer cu3 = new Customer(3L, "Peter", "Parker", "pp@mail.com");
        Customer cu4 = new Customer(4L, "Bruce", "Wayn", "bw@mail.com");
        CustomerTable.insertCustomer(cu1);
        CustomerTable.insertCustomer(cu2);
        CustomerTable.insertCustomer(cu3);
        CustomerTable.insertCustomer(cu4);
        
        Address add1 = new Address(1L,"123/4 Viphavadee Rd.","Bangkok", "10900", "TH" );
        add1.setCustomerFk(cu1);
        cu1.setAddressId(add1); 
        Address add2 = new Address(2L,"123/5 Viphavadee Rd.","Bangkok", "10900", "TH" );
        add2.setCustomerFk(cu2);
        cu2.setAddressId(add2); 
        Address add3 = new Address(3L,"543/21 Fake Rd.","Nonthaburi", "20900", "TH" );
        add3.setCustomerFk(cu3);
        cu3.setAddressId(add3); 
        Address add4 = new Address(4L,"678/90 Unreal Rd.","Pathumthani", "30500", "TH" );
        add4.setCustomerFk(cu4);
        cu4.setAddressId(add4); 
        
        
        AddressTable.insertAddress(add1);
        AddressTable.insertAddress(add2);
        AddressTable.insertAddress(add3);
        AddressTable.insertAddress(add4);
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(cu1);
            em.persist(add1);
            /*em.getTransaction().commit();
            em.persist(cu2);
            em.persist(add2);
            em.getTransaction().commit();
            em.persist(cu3);
            em.persist(add3);
            em.getTransaction().commit();
            em.persist(cu4);
            em.persist(add4);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        try {
            em.persist(cu2);
            em.persist(add2);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }*/
    }
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EntityManagerDemo2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
