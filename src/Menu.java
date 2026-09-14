import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            case 1 -> registerBooking(scan);
            case 2 -> System.out.println("showAllaBookings()");
            case 3 -> System.out.println("showSummary()");
            case 4 -> {
                System.out.println("Avslutar programmet");
                continueAction = false;
            }
        }
        return continueAction;
    }

    static void registerBooking(Scanner scan) {
        printActivities();
        int activityIndex = InputReader.readIntWithCondition(scan,"Aktivitet? ",
                1, Main.ACTIVITIES.length) - 1;
        int numOfParticipants = InputReader.readIntWithCondition(scan,"Antal deltagare? ",
                1, Main.MAX_NUM_PARTICIPANTS);

        int price = calculateBookingPrice(activityIndex, numOfParticipants);
        System.out.println("Registrerad en ny bokning:");
        String bookingInfo = Main.ACTIVITIES[activityIndex] + ", " + numOfParticipants + " deltagare, " + price + " kr";
        System.out.println(bookingInfo);
        writeToFile(bookingInfo, Main.OUT_FILENAME);
    }

    static void printActivities() {
        System.out.println("\n------------------------");
        System.out.println("AKTIVITETER:");
        System.out.println("------------------------");
        for (int i = 0; i < Main.ACTIVITIES.length; i++) {
            System.out.format("%2d %-25s %4d\n", i + 1, Main.ACTIVITIES[i], Main.PRICES[i]);
        }
        System.out.println("------------------------\n");
    }

    static int calculateBookingPrice (int activityIndex, int numOfParticipants){
        return Main.PRICES[activityIndex] * numOfParticipants;
    }

    static void writeToFile(String s, String filename) {
        try {
            PrintWriter outfile = new PrintWriter( new BufferedWriter( new FileWriter(filename, true)));
            outfile.println(s);
            outfile.close();
            System.out.println("Sparad till filen " + filename);
        } catch (IOException e) {
            System.out.println("Ett fel uppstod:");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}