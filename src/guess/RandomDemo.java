package guess;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int r = random.nextInt(100) + 1;
            System.out.println(r);
        }
        }

}
