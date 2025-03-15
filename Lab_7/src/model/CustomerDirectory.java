/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tiankaining
 */

public class CustomerDirectory {
    private List<Customer> customerList;
    
    public CustomerDirectory() {
        customerList = new ArrayList<Customer>();
        
        // Add a default customer for testing
        Customer defaultCustomer = new Customer();
        defaultCustomer.setName("John Doe");
        defaultCustomer.setUsername("customer");
        defaultCustomer.setPassword("password");
        customerList.add(defaultCustomer);
    }
    
    public List<Customer> getCustomerList() {
        return customerList;
    }
    
    public Customer addCustomer() {
        Customer newCustomer = new Customer();
        customerList.add(newCustomer);
        return newCustomer;
    }
    
    public void removeCustomer(Customer c) {
        customerList.remove(c);
    }
    
    public Customer searchCustomer(String username) {
        for (Customer customer : customerList) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }
    
    public boolean validateCredentials(String username, String password) {
        for (Customer customer : customerList) {
            if (customer.getUsername().equals(username) && 
                customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
