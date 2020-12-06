package guess;

import java.util.Scanner;

public class dowhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("You are GORGEOUS!");
            System.out.println("Do you want me to tell that again?");

        }while (scanner.next().equalsIgnoreCase("yes"));

        int age;
        do {
            System.out.println("Tell me how old are you?");
           age = scanner.nextInt() ;
            System.out.println("You said that " + age);
        }while (age < 21);
        System.out.println("Bye");
    }
}
