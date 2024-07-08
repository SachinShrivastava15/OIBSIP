import java.util.Scanner;

public class OnlineReservation{

    private static boolean[] seats = new boolean[10];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {


            System.out.println("\nPlease select an option:");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            int option = sc.nextInt();

            switch (option) {

                case 1:
                    ViewSeatMap();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid response!");
            }
        }
    }

    private static void ViewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("R"); //
            } else {
                System.out.print((i + 1) + " "); 
            }
        }
        System.out.println();
    }

    private static void reserveSeat() {
        Scanner obj = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = obj.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true;
            System.out.println("Enter your Name");
            obj.nextLine();
            String name= obj.nextLine(); 
            System.out.println("Seat reserved by "+name);
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number..!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("This seat is not reserved yet!");
        } else {
            seats[seatNumber - 1] = false;
            System.out.println("Reservation successfully canceled!");
        }
    }
}