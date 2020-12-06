package guess;

import java.util.Scanner;

public class WhileDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" do you");
        while (scanner.next().equals("yes")){
            System.out.println( "doing");
            System.out.println("do you repeat");
        }
        System.out.println("Bye");
    }
}
