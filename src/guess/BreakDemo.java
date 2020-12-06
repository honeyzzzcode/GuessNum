package guess;

import java.util.Scanner;

public class BreakDemo {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("How many times?");
        int count = scanner.nextInt();
        for (int i = 1; i < count; i++) {
            System.out.println("Repeating" + i );
            System.out.println("Do you want to cancel?");
            if (scanner.next().equalsIgnoreCase("yes"))
            {
                break;
            }

        }
        System.out.println("Bye");

    }



}
