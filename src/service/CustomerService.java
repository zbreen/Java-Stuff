package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    private static Map<String, Customer> emailToPerson;
    private static Set<Customer> PersonSet = new HashSet<Customer>();

    public static void addCustomer(String email, String firstName, String lastName){
        Customer c = new Customer(firstName, lastName, email);
        PersonSet.add(c);
        emailToPerson.put(email, c);
    }
    public static Customer getCustomer(String customerEmail){
        for (Customer x: PersonSet){
            if(x.getEmail() == customerEmail){
                return x;
            }
        }
        //return emailToPerson.get(customerEmail);
        return null;
    }
    public Collection<Customer> getAllCustomers(){
        return PersonSet;
    }
}
