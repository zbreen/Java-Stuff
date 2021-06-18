package Menus;
import api.HotelResource;
import model.Customer;
import model.IRoom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class MainMenu {
    public static void MainMenu() throws ParseException{
        boolean isFunction = true;
        Collection<IRoom> collectedList; //= new HashSet<~>();
        while (isFunction) {
            System.out.println("Welcome to the Hotel Reservation Application\n----------------------");
            //System.out.println("----------------------");
            System.out.println("1. Find and reserve a room.\n2. See my reservations.\n" +
                    "3. Create an Account.\n4. Admin\n5. Exit\n----------------------\n" +
                    "Please select a number for the menu option");
            Scanner userInput = new Scanner(System.in);
            switch (userInput.nextLine()) {
                case "1":
                    System.out.println("Enter check in date (mm/dd/yyyy)");
                    Scanner userCheckIn = new Scanner(System.in);
                    System.out.println("Enter check out (mm/dd/yyyy)");
                    Scanner userCheckOut = new Scanner(System.in);
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
                    String date1 = userCheckIn.nextLine();
                    String date2 = userCheckOut.nextLine();
                    Date checkIn = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
                    //Date checkIn = formatter.parse(userCheckIn.nextLine());
                    //Date checkOut = formatter.parse(userCheckOut.nextLine());
                    Date checkOut = new SimpleDateFormat("dd-MM-yyy").parse(date2);
                    collectedList = HotelResource.findARoom(checkIn, checkOut);
                    if(collectedList.size() != 0) {


                        System.out.println(collectedList);
                        System.out.println("Would you like to book a room? Y/N");
                        Scanner userResponse = new Scanner(System.in);
                        boolean accountMake = true;
                        while (accountMake) {
                            if (userResponse.nextLine().toLowerCase() == "y") {
                                System.out.println("Do you have an account?");
                                Scanner userAccount = new Scanner(System.in);
                                if (userAccount.nextLine().toLowerCase() == "y") {
                                    System.out.println("Enter Email. Format: name@domain.com");
                                    Scanner userEmail = new Scanner(System.in);
                                    boolean emailFound = false;
                                    while(!emailFound) {
                                        if (CustomerService.getCustomer(userEmail.nextLine()) != null) {
                                            System.out.println("What room number would you like to reserve?");
                                            Scanner userRoom = new Scanner(System.in);
                                            /*SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
                                            String date1 = userCheckIn.nextLine();
                                            String date2 = userCheckOut.nextLine();
                                            Date checkIn = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
                                            //Date checkIn = formatter.parse(userCheckIn.nextLine());
                                            //Date checkOut = formatter.parse(userCheckOut.nextLine());
                                            Date checkOut = new SimpleDateFormat("dd-MM-yyy").parse(date2);*/
                                            HotelResource.bookARoom(userEmail.nextLine(),
                                                    HotelResource.getRoom(userRoom.nextLine()), checkIn,
                                                    checkOut);
                                            accountMake = false;
                                            emailFound = true;
                                        } else {
                                            System.out.println("Email not found, re-enter");
                                        }
                                    }
                                } else if (userAccount.nextLine().toLowerCase() == "n") {
                                    System.out.println("Enter Email. Format: name@domain.com");
                                    Scanner userEmail = new Scanner(System.in);
                                    System.out.println("First name");
                                    Scanner userFirstName = new Scanner(System.in);
                                    System.out.println("Last name");
                                    Scanner userLastName = new Scanner(System.in);
                                    HotelResource.createACustomer(userEmail.nextLine(), userFirstName.nextLine(),
                                            userLastName.nextLine());
                                    System.out.println("What room number would you like to reserve?");
                                    Scanner userRoom = new Scanner(System.in);
                                    /*SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
                                    String date1 = userCheckIn.nextLine();
                                    String date2 = userCheckOut.nextLine();
                                    Date checkIn = new SimpleDateFormat("dd-MM-yyyy").parse(date1);
                                    //Date checkIn = formatter.parse(userCheckIn.nextLine());
                                    //Date checkOut = formatter.parse(userCheckOut.nextLine());
                                    Date checkOut = new SimpleDateFormat("dd-MM-yyy").parse(date2);*/
                                    HotelResource.bookARoom(userEmail.nextLine(),
                                            HotelResource.getRoom(userRoom.nextLine()), checkIn,
                                            checkOut);
                                    accountMake = false;
                                }
                                else{
                                    System.out.println("Enter y/n");
                                }
                            }
                        }
                    }
                    break;
                case "2":
                    System.out.println("Enter Email. Format: name@domain.com");
                    Scanner userEmail = new Scanner(System.in);
                    Customer c = HotelResource.getCustomer(userEmail.nextLine());
                    System.out.println(HotelResource.getCustomersReservations(c.getEmail()));
                    break;

                case "3":
                    System.out.println("Enter Email. Format: name@domain.com");
                    Scanner userEmailTwo = new Scanner(System.in);
                    System.out.println("First name");
                    Scanner userFirstName = new Scanner(System.in);
                    System.out.println("Last name");
                    Scanner userLastName = new Scanner(System.in);
                    HotelResource.createACustomer(userEmailTwo.nextLine(), userFirstName.nextLine(),
                            userLastName.nextLine());
                    break;

                case "4":
                    AdminMenu.AdminMenu();
                case "5":
                    isFunction = false;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
