package guess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class GuessNum {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    static Scanner scanner = new Scanner(System.in);
    private static final ArrayList<GameResult> leaderboard = new ArrayList<>();
    private static File leaderboardFile = new File("leaderboard.txt");
    ;
    public static void main(String[] args) {
        laodLeaderboard ();
        boolean userChoice;
        Random random = new Random();
        String userName;
        do {
            System.out.println("What is your name?");
            userName = scanner.next();
            int myNum = random.nextInt(100) + 1;

            System.out.println("Hello , " + userName + " !");
            System.out.println("I am thinking of number from 1 to 100, try to guess it!" + myNum);
            long startTime = System.currentTimeMillis();
            boolean userWin = false;

            for (int i = 1; i <= 10; i++) {

                System.out.printf("Attempt#%d.\n", i);
                int userNum = askNumber("Your guess", 1, 100);
                if (myNum < userNum) {
                    System.out.println(userName + ", Your number is too high");
                } else if (myNum > userNum) {
                    System.out.println(userName + ", Your number is too low");
                } else {
                    long endTime = System.currentTimeMillis();
                    GameResult gr = new GameResult();
                    gr.setName(userName);
                    gr.setAttempts(i);
                    gr.setDuration(endTime - startTime);
                    gr.setStarttime(startTime);

                    leaderboard.add(gr);

                    System.out.printf(userName + " You won! %d attempts were used.\n", i);
                    userWin = true;
                    break;
                }
            }
            if (!userWin) {
                System.out.printf("You lost.My number was %d\n", myNum);
            }
            userChoice = askYesOrNo("Would you like to play again?");
            if (!userChoice) {
                System.out.println("Bye ," + userName);
                break;
            }
        } while (true);
        saveLeaderboard();
       printlead3();
    }

    private static void laodLeaderboard() {
        try (var in = new Scanner(leaderboardFile)){
            while ((in.hasNext())){
                var gr = new GameResult();
                gr.setName(in.next());
                gr.setAttempts(in.nextInt());
                gr.setDuration(in.nextLong());
                gr.setStarttime(in.nextLong());
                leaderboard.add(gr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("cannt read leaderboard");
        }
    }

    private static void saveLeaderboard() {

        try (var out = new PrintWriter(leaderboardFile)) {
            for (var gr : leaderboard){
                out.printf("%s %d  %d %d \n" , gr.getName(),gr.getAttempts(),gr.getDuration(),gr.getStarttime());
            }

        } catch (FileNotFoundException e) {
            System.out.println("cannot save leaderboard");
        }

    }

    private static void printleaderboard() {
        leaderboard.sort(
                Comparator
                        .comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );
        System.out.printf("NAME  \t              ATTEMPTS \t            DURATION             START TIME\n");
        for (GameResult gr : leaderboard) {

            System.out.printf("  %-15s \t    %-15d \t %.1f%n %.1f\n ", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
        }
    }
    private static void printleaderboard2 (){
        leaderboard.sort(
                Comparator.comparingInt(GameResult::getAttempts)
                .thenComparingLong(GameResult::getDuration)
        );
        var rows = 5;
        for (GameResult gr : leaderboard){
            System.out.printf("  %-15s \t    %-15d \t %.1f%n \n ", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
            rows--;
            if ((rows == 0)){break;
        }
    }}

    private static void printlead3(){
        Date date = new Date();
        leaderboard.sort(
                Comparator.comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
        );System.out.printf("NAME  \t              ATTEMPTS \t            DURATION             START TIME\n");
        var num = Math.min(5,leaderboard.size());
        var sublist = leaderboard.subList(0,num);
        for (GameResult gr: sublist){

            System.out.printf("  %-15s \t    %-15d \t %.1f  \t         %s \n ", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0 , sdf.format(date));//gr.getStarttime() /1000.0);
    }}

    public static void printleaderboard5(){

        leaderboard.stream()
                .filter(gr -> !gr.getName().equals("hhh"))
                .sorted(Comparator.comparingInt(GameResult::getAttempts)
                        .thenComparingLong(GameResult::getDuration)
                )
                .limit(5)
                .forEach(gr -> {

                    System.out.printf("  %-15s \t    %-15d \t %.1f%n \n ", gr.getName(), gr.getAttempts(), gr.getDuration() / 1000.0);
                });
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
        while (true) {
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
