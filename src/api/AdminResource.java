package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }
    public static void addRoom(List<IRoom> rooms){

    }
    public static Collection<IRoom> getAllRooms(){
        return null;
    }
    public static Collection<Customer> getAllCustomers(){
        return null;
    }
    public static void displayAllReservations(){
        ReservationService.printAllReservation();
    }
}
