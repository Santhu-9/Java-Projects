import dao.GuestDAO;
import model.Guest;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GuestDAO dao = new GuestDAO();

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("Welcome to Hotel Reservation");
            System.out.println("1. Reserve a room");
            System.out.println("2. View Reservations");
            System.out.println("3. Get Room Number");
            System.out.println("4. Update Reservations");
            System.out.println("5. Delete Reservations");
            System.out.println("0. Exit");

            int ch =  sc.nextInt();
            sc.nextLine();

            switch (ch){

                case 1:

                    System.out.println("Enter guest name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter room no: ");
                    int room_no = sc.nextInt();

                    System.out.println("Enter contact no: ");
                    String contact_no = sc.next();

                    Guest guest = new Guest(name,room_no,contact_no);

                    dao.addGuest(guest);

                    break;

                case 2:

                    dao.viewReservations();

                    break;

                case 3:

                    System.out.println("Enter Reservation ID: ");
                    int id = sc.nextInt();

                    dao.getRoomNo(id);

                    break;

                case 4:

                    System.out.println("Enter Reservation ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter new guest name: ");
                    String newName = sc.nextLine();

                    System.out.println("Enter new room no: ");
                    int newRoomNo = sc.nextInt();

                    System.out.println("Enter new contact no: ");
                    String newContactNo = sc.next();

                    Guest updatedGuest = new Guest(newName,newRoomNo,newContactNo);
                    dao.updateReservations(id, updatedGuest);

                    break;

                case 5:

                    System.out.println("Enter Reservaion ID: ");
                    id = sc.nextInt();

                    dao.deleteReservations(id);

                    break;

                case 0:

                    System.exit(0);

                default:

                    System.out.println("Wrong choice");
            }
        }
    }
}
