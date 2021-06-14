package Menus;

import api.AdminResource;
import model.RoomType;

import java.util.Scanner;

import static model.RoomType.DOUBLE;
import static model.RoomType.SINGLE;

public class AdminMenu {
    public static void AdminMenu() {
        boolean isFunction = true;
        boolean makeRoom = true;
        while (isFunction) {
            System.out.println("Admin Menu\n1. See all Customers\n2. See all Rooms\n" +
                    "3. See all Reservations\n4. Add a Room\n5. Back to Main Menu" +
                    "\n----------------------\n" +
                    "Please select a number for the menu option");
            Scanner userInput = new Scanner(System.in);
            switch (userInput.nextLine()) {
                case "1":
                    AdminResource.getAllCustomers();
                    break;
                case "2":
                    AdminResource.getAllRooms();
                    break;
                case "3":
                    AdminResource.displayAllReservations();
                    break;
                case "4":
                    while(makeRoom) {
                        RoomType r;
                        System.out.println("Enter room number");
                        Scanner userRoom = new Scanner(System.in);
                        System.out.println("Enter price per night");
                        Scanner userPrice = new Scanner(System.in);
                        System.out.println("Enter room type: 1 for single, 2 for double");
                        Scanner userType = new Scanner(System.in);
                        if (userType.nextLine() == "2") {
                            r = DOUBLE;
                        } else {
                            r = SINGLE;
                        }
                        AdminResource.addRoom(userRoom.nextLine(), userPrice.nextLine(), r);
                        System.out.println("Make another room? Y/N");
                        boolean choiceMade = false;
                        while(!choiceMade) {
                            Scanner userChoice = new Scanner(System.in);
                            if (userChoice.nextLine().toLowerCase() == "y") {
                                makeRoom = true;
                                choiceMade = true;
                            } else if (userChoice.nextLine().toLowerCase() == "n") {
                                makeRoom = false;
                                choiceMade = true;
                            } else{
                                System.out.println("Please choose y/n");
                            }
                        }
                    }
                    break;
                case "5":
                    isFunction = false;
                    //MainMenu.MainMenu();

                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
        MainMenu.MainMenu();
    }
}
