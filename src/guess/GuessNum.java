package guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Random random = new Random();
        String userName;
        boolean userChoice;
        do {
            System.out.println("What is your name?");
            userName = scanner.next();
            int myNum = random.nextInt(100) + 1;

            System.out.println("Hello , " + userName + " !");
            System.out.println("I am thinking of number from 1 to 100, try to guess it!");
            boolean userWin = false;

            for (int i = 1; i <= 10; i++) {

                System.out.printf("Attempt#%d.\n", i);
                int userNum = askNumber("Your guess", 1, 100);
                if (myNum < userNum) {
                    System.out.println(userName + ", Your number is too high");
                } else if (myNum > userNum) {
                    System.out.println(userName + ", Your number is too low");
                } else {
                    System.out.printf(userName + " You won! %d attempts were used.\n", i);
                    userWin = true;
                    break;
                }
            }
            if (!userWin) {
                System.out.printf("You lost.My number was %d\n", myNum);
            }
            userChoice = askYesOrNo("Would you like to play again?");
            if (userChoice = false) {
                System.out.println("Bye ," + userName);
                break;
            }
        } while(userChoice = true);
    }
    public static int askNumber(String msg, int min, int max) {
        while (true) {
            System.out.println(msg + ":");
            try {
                int result = scanner.nextInt();
                if (result < min) {
                    System.err.println("number should not be more than" + min);
                    continue;
                } else if (result > max) {
                    System.err.println("number should not be less than" + max);
                    continue;
                }
                return result;
            } catch (InputMismatchException e) {
                String input = scanner.next();
                System.out.println(input + " is not number");
                System.err.println("this is not number");
            }
        }
    }
    public static Boolean askYesOrNo(String msg) {
        boolean yesorno;
        while(true) {
            System.out.println(msg + "(Yes or No)?");
            String result = scanner.next();
            if (result.equalsIgnoreCase("No")) {
                yesorno = false;
                break;
            } else if (result.equalsIgnoreCase("yes")) {
                yesorno = true;
                break;
            }
        }
        return yesorno;
    }
}
