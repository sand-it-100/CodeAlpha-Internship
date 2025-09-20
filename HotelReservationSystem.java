import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Add Rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        int choice;
        do {
            System.out.println("\n===== Hotel Reservation System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    bookRoom(sc);
                    break;
                case 3:
                    cancelRoom(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }

    public static void viewRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println("Room " + r.roomNumber + " (" + r.category + ")");
            }
        }
    }

    public static void bookRoom(Scanner sc) {
        System.out.print("Enter room number to book: ");
        int num = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == num && !r.isBooked) {
                r.isBooked = true;
                System.out.println("Room " + num + " booked successfully!");
                return;
            }
        }
        System.out.println("Room not available or already booked!");
    }

    public static void cancelRoom(Scanner sc) {
        System.out.print("Enter room number to cancel: ");
        int num = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == num && r.isBooked) {
                r.isBooked = false;
                System.out.println("Reservation for room " + num + " cancelled!");
                return;
            }
        }
        System.out.println("No reservation found for this room!");
    }
}