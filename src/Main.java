import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static final ArrayList<Booking> BOOKINGS = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean continueAction = true;
        while (continueAction) {
            printMenu();
            continueAction = userAction(scan);
        }
    }

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
        int choice = readIntWithCondition(scan, "Ange ditt val: ", 1, 4);
        switch (choice) {
            case 1 -> registerBooking(scan);
            case 2 -> showAllBookings();
            case 3 -> printSummary();
            case 4 -> {
                System.out.println("Avslutar programmet");
                continueAction = false;
            }
        }
        return continueAction;
    }

    static void registerBooking(Scanner scan) {
        printActivities();
        int activityIndex = readIntWithCondition(scan,"Aktivitet? ",
                1, Booking.ACTIVITIES.length) - 1;
        int numOfParticipants = readIntWithCondition(scan,"Antal deltagare? ",
                1, Booking.MAX_NUM_PARTICIPANTS);

        int price = Booking.calculateBookingPrice(activityIndex, numOfParticipants);

        Booking booking = new Booking(activityIndex, numOfParticipants, price);
        System.out.println("Registrerad en ny bokning:");
        System.out.println(booking);
        Main.BOOKINGS.add(booking);
        System.out.println(Main.BOOKINGS.size());
    }

    static void printActivities() {
        System.out.println("\n------------------------");
        System.out.println("AKTIVITETER:");
        System.out.println("------------------------");
        for (int i = 0; i < Booking.ACTIVITIES.length; i++) {
            System.out.format("%2d %-25s %4d\n", i + 1, Booking.ACTIVITIES[i], Booking.PRICES[i]);
        }
        System.out.println("------------------------\n");
    }

    static void showAllBookings(){

        if (Main.BOOKINGS.size() == 0)
            System.out.println(" Inga registrerade bokningar.");

        System.out.println(" Alla bokningar: ");
        for (int i = 0; i < Main.BOOKINGS.size(); i++) {
            System.out.println("Booking "+ (i + 1) + ": " + Main.BOOKINGS.get(i));
        }
    }

    public static void printSummary(){
        //Metod som skriver ut totalsumman

        System.out.println("Totalt antal bokningar: " + Main.BOOKINGS.size());
        int totalSum = 0;
        for (Booking booking: Main.BOOKINGS) {
            totalSum += booking.getPrice();
        }
        System.out.println("Sammanlagt värde för alla bokningar: " + totalSum + " kr.");

        for (int i = 0; i < Booking.ACTIVITIES.length; i++) {
            int numBookings = 0;
            for (Booking booking: Main.BOOKINGS) {
                if (booking.getActivityIndex() == i)
                    numBookings++;
            }
            System.out.println("Antal bokningar för " + Booking.ACTIVITIES[i] + ": " + numBookings);
        }
    }

    static int readIntWithCondition(Scanner scan, String message, int min, int max) {
        while (true) {
            int num;
            System.out.print(message);
            try {
                num = scan.nextInt();
                if (num >= min && num <= max)
                    return num;
                System.out.println("Talet måste vara >= " + min + " och <= " + max);
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Felaktigt heltal, försök igen");
            } catch (NoSuchElementException e) {
                System.out.println("Avslutar programmet");
                System.exit(0);
            }
        }
    }
}
