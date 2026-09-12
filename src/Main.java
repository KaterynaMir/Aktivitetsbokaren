import java.util.Scanner;

public class Main {

    public static final String[] ACTIVITIES = {"Programmeringsworkshop","Matlagningskurs","Träningspass"};
    public static final int[] PRICES = {200, 300, 150};
    public static final int MAX_NUM_PARTICIPANTS = 500;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean continueAction = true;
        while (continueAction) {
            Menu.printMenu();
            continueAction = Menu.userAction(scan);
        }
    }
}
