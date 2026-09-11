import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputReader {

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
