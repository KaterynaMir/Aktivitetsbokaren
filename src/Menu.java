import java.util.Scanner;

public class Menu {


    static void printMenu () {
        //AKTIVITETSBOKAREN

        System.out.println("\n------------------------");
        System.out.println("AKTIVITETSBOKAREN");
        System.out.println("------------------------");
        System.out.println("1. Registrera bokning");
        System.out.println("2. Visa alla bokningar");
        System.out.println("3. Visa sammanställning");
        System.out.println("4. Avsluta");
        System.out.println("------------------------\n");
    }

    static boolean userAction(Scanner scan) {
        boolean continueAction = true;
        int choice = InputReader.readIntWithCondition(scan, "Ange ditt val: ", 1, 4);
        switch (choice) {
            case 1 -> System.out.println("registerBooking()");
            case 2 -> System.out.println("showAllaBookings()");
            case 3 -> System.out.println("showSummary()");
            case 4 -> {
                System.out.println("Avslutar programmet");
                continueAction = false;
            }
        }
        return continueAction;
    }
}