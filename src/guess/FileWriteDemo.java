package guess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriteDemo {
    public static void main(String[] args) {
        File file = new File("test.txt");
        try (var out = new PrintWriter(file)) {
            out.println("Hello, World!");
        } catch (FileNotFoundException e) {
            System.out.println("cannot save file");
        }
    }
}
