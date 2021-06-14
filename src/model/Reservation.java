package model;
import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer(){
        return customer;
    }

    public IRoom getIRoom(){
        return room;
    }

    public Date getCheckInDate(){
        return checkInDate;
    }

    public Date getCheckOutDate(){
        return checkOutDate;
    }

    @Override
    public String toString() {
        {return "The customer is " + customer.getFirstName() + " " + customer.getLastName() + ", they're in " +
                room.getRoomNumber() + ", they check in at " + checkInDate.toString() + " and checked out at " +
                checkOutDate.toString(); }
    }
}
