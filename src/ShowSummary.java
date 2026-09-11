import java.util.Scanner;

public class ShowSummary {

    public static final String[] ACTIVITIES = {"Programmeringsworkshop", "Matlagningskurs", "Träningspass"};
    public static final int[] PRICES = {200, 300, 150};


    public static int countSummary(int[] numOfParticipants) {  //Metod som tar emot
        int totalPrice = 0;
        for (int i = 0; i < PRICES.length; i++) {
            totalPrice += PRICES[i] * numOfParticipants[i];
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numOfParticipants = new int[ACTIVITIES.length];

        for (int i = 0; i < ACTIVITIES.length; i++) {
            String question = "Aktivitet: " + ACTIVITIES[i] + "\nPris: " + PRICES[i] + "\nAntal: ";
            numOfParticipants[i] = InputReader.readIntWithCondition(scan, question, 0, Integer.MAX_VALUE);
        }
        int total = countSummary(numOfParticipants);
        System.out.println("Totalpriset är: " + total + " Kr.");

    }
}


