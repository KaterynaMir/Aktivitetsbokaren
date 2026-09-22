import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Booking> BOOKINGS = new ArrayList<>();
    private static final String LINE = "--------------------------------------------";

    public static void main(String[] args) {
        //Kör huvudprogramsloopen
        try(Scanner scan = new Scanner(System.in)) {
            boolean continueAction = true;
            while (continueAction) {
                printMenu();
                continueAction = userAction(scan);
            }
        }catch(NoSuchElementException e) {
            // Avslutar programmet om användaren trycker på Cmd-D/Ctrl+Z.
            System.out.println("Avslutar programmet");
        }
    }

    public static void printMenu () {
        // Skriver ut programmets huvudmeny.

        printHeader("AKTIVITETSBOKAREN");
        System.out.println("1. Registrera bokning");
        System.out.println("2. Visa alla bokningar");
        System.out.println("3. Visa sammanställning");
        System.out.println("4. Avsluta");
        printLine();
    }

    public static boolean userAction(Scanner scan) {
        // Läser användarens menyval och kör rätt metod.
        int choice = readIntInInterval(scan, "Ange ditt val: ", 1, 4);
        switch (choice) {
            case 1 -> registerBooking(scan);
            case 2 -> showAllBookings();
            case 3 -> printSummary();
            case 4 -> {
                System.out.println("Avslutar programmet");
                return false;
            }
        }
        return true;
    }

    public static void registerBooking(Scanner scan) {
        // Låter användaren välja aktivitet och antal deltagare samt skapar en bokning.
        printActivities();
        int activityIndex = readIntInInterval(scan,"Aktivitet? ",
                1, Booking.ACTIVITIES.length) - 1;
        int numOfParticipants = readIntInInterval(scan,"Antal deltagare? ",
                1, Booking.MAX_NUM_PARTICIPANTS);


        Booking booking = new Booking(activityIndex, numOfParticipants);
        System.out.println("Registrerad en ny bokning:");
        System.out.println(booking);
        BOOKINGS.add(booking);
    }

    public static void printActivities() {
        // Skriver ut alla aktiviteter och deras priser per deltagare.
        printHeader("AKTIVITETER:              Pris per deltagare:");
        for (int i = 0; i < Booking.ACTIVITIES.length; i++) {
            System.out.format("%2d %-25s %4d kr\n", i + 1, Booking.ACTIVITIES[i], Booking.PRICES[i]);
        }

    }

    public static void showAllBookings(){
        // Visar alla registrerade bokningar
        if (BOOKINGS.isEmpty()){
            printHeader("Inga registrerade bokningar.");
            return;
        }
        printHeader("Alla bokningar: ");
        for (int i = 0; i < BOOKINGS.size(); i++) {
            System.out.println("Bokning "+ (i + 1) + ": " + BOOKINGS.get(i));
        }
        printLine();
    }

    public static void printSummary(){
        // Skriver ut en sammanställning av alla bokningar och deras totala värde.
        int[] bookingsPerActivity = new int[Booking.ACTIVITIES.length];
        printHeader("Totalt antal bokningar: " + BOOKINGS.size());
        int totalSum = 0;
        for (Booking booking: BOOKINGS) {
            bookingsPerActivity[booking.getActivityIndex()]++;
            totalSum += booking.getPrice();
        }
        System.out.println("Sammanlagt värde för alla bokningar: " + totalSum + " kr");

        for (int i = 0; i < Booking.ACTIVITIES.length; i++) {
            System.out.println("Antal bokningar för " + Booking.ACTIVITIES[i] + ": " + bookingsPerActivity[i]);
        }
        printLine();
    }

    public static int readIntInInterval(Scanner scan, String message, int min, int max) {
        // Läser in ett heltal och kontrollerar att det ligger inom angivet intervall.
        while (true) {
            int num;
            System.out.print(message);
            try {
                num = scan.nextInt();
                if (num >= min && num <= max){
                    return num;
                }
                System.out.println("Talet måste vara mellan " + min + " och " + max);
            } catch (InputMismatchException e) {
                // Hanterar om användaren skriver något som inte är ett heltal.
                scan.nextLine();
                System.out.println("Felaktigt heltal, talet måste vara mellan " + min + " och " + max);
            }
        }
    }
    private static void printLine(){
        System.out.println(LINE);
    }
    private static void printHeader(String title){
        System.out.println();
        printLine();
        System.out.println(title);
        printLine();
    }

}

