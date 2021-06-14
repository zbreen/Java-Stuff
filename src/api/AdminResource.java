package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;
import java.util.*;

public class AdminResource {
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }
    public static void addRoom(List<IRoom> rooms){
        for(IRoom i: rooms){
            ReservationService.addRoom(i);
        }
    }
    public static Collection<IRoom> getAllRooms(){
        return ReservationService.getAllRooms();
    }
    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }
    public static void displayAllReservations(){
        ReservationService.printAllReservation();
    }
}
