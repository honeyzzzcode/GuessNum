package guess;

import java.util.Scanner;

public class SkannerDemo {

    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello , " + userName + " !");
        boolean isGleb = userName.equalsIgnoreCase("Gleb");
        boolean isZlata = userName.equalsIgnoreCase("Zlata");
        if (isGleb ) {
            System.out.println("You love Zlata and to fart");
        } else if (isZlata){
            System.out.println("You love Gleb");}
        else{  System.out.println("You are Gleb"); }
            System.out.println("Enter your favourite number?");
            int favNum = scanner.nextInt();
            System.out.println("I know your favourite number. It is " + favNum +  "woahahahaha");
            System.out.println ("Bye KISS YOU");
        }

    }
