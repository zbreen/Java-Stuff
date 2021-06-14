package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    private Map<Room, Customer> PersonToRoom;
    private static Set<IRoom> rooms = new HashSet<IRoom>();
    //private Set<IRoom> availableRooms = new HashSet<IRoom>();
    private static Set<Reservation> reservations = new HashSet<Reservation>();
    //private Set<Reservation> foundReservations;
    public void addRoom(IRoom room){
        rooms.add(room);
    }
    public static IRoom getARoom(String roomId){
        for(IRoom i: rooms){
            if(i.getRoomNumber() == roomId){
                return i;
            }
        }
        return null;
    }
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation r = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(r);
        return r;
    }
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Set<IRoom> availableRooms = new HashSet<IRoom>();
        for(Reservation r: reservations){
            if (r.getCheckInDate().after(checkInDate) && r.getCheckOutDate().before(checkOutDate)){
                availableRooms.add(r.getIRoom());
            }
        }
        return availableRooms;
    }
    public static Collection<Reservation> getCustomersReservation(Customer customer){
        Set<Reservation> foundReservations = new HashSet<Reservation>();
        for(Reservation r: reservations){
            if(r.getCustomer() == customer){
                foundReservations.add(r);
            }
        }
        return foundReservations;
    }

    public static void printAllReservation(){
        for(Reservation r: reservations){
            System.out.println(r);
        }
    }
}
