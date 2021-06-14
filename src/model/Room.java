package model;

public class Room implements IRoom{
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration){

        this.roomNumber = roomNumber;
        this.price = 0.00;
        this.enumeration = enumeration;
    }

    @Override
    public String getRoomNumber(){
        return roomNumber;
    }
    @Override
    public Double getRoomPrice(){
        return price;
    }
    @Override
    public RoomType getRoomType(){
        return enumeration;
    }
    @Override
    public boolean isFree(){
        return price == 0;
    }

    @Override
    public String toString() {
        {return "Room Number: " + roomNumber + " " + enumeration + ", price is " + price; }
    }

}
