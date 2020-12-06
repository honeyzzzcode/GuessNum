package guess;

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("enter number 1 to 3");
            int userNum = scanner.nextInt();
            switch (userNum){
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                case 5:
                case 6:
                    System.out.println("Too many");
                    break;
                default:
                    System.out.println("Wrong");
                    break;
            }
        }
    }
}
