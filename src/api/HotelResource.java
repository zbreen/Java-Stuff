package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class HotelResource {
    private Set<Customer> customerList = new HashSet<Customer>();
    private Set<IRoom> roomList = new HashSet<IRoom>();
    //private Map<Customer, Reservation> reservationList = new HashMap<Customer, Reservation>();
    private Set<Reservation> reservationList = new HashSet<Reservation>();
    public static Customer getCustomer(String email){
        /*for (Customer x: customerList){
            if(x.getEmail() == email){
                return x;
            }
        }
        return null;*/
        return CustomerService.getCustomer(email);
    }
    public static void createACustomer(String email, String firstName, String lastName){
        /*Customer c = new Customer(email, firstName, lastName);
        customerList.add(c);*/
        CustomerService.addCustomer(email, firstName, lastName);
    }
    public static IRoom getRoom(String roomNumber){
        /*for (IRoom x: roomList){
            if(x.getRoomNumber() == roomNumber){
                return x;
            }
        }
        return null;*/
        return ReservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        /*Reservation r = null;
        for (Customer x: customerList){
            if(x.getEmail() == customerEmail){
                r = new Reservation(x, room, checkInDate, checkOutDate);
                reservationList.add(r);
            }
        }
        return r;*/
        return ReservationService.reserveARoom(CustomerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail){
      /*  Set<Reservation> foundReservations = new HashSet<Reservation>();
        for(Reservation r: reservationList){
            if(r.getCustomer().getEmail() == customerEmail){
                foundReservations.add(r);
            }
        }
        return foundReservations;*/
        return ReservationService.getCustomersReservation(CustomerService.getCustomer(customerEmail));
    }

    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        /*Set<IRoom> availableRooms = new HashSet<IRoom>();
        for(Reservation r: reservationList){
            if (r.getCheckInDate().after(checkInDate) && r.getCheckOutDate().before(checkOutDate)){
                availableRooms.add(r.getIRoom());
            }
        }
        return availableRooms;*/
        return ReservationService.findRooms(checkInDate, checkOutDate);
    }
}
