package guess.reg;

import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        //RegistrationForm[] regs = new RegistrationForm[100];
        ArrayList<RegistrationForm> regs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("New registration");
            RegistrationForm frm = new RegistrationForm();

            System.out.println("Name");
            frm.fullname = scanner.next();

            System.out.println("Age");
            frm.age = scanner.nextInt();

            System.out.println("Phone");
            frm.phone = scanner.next();

            regs.add(frm);

            System.out.println("more?");
            if (scanner.next().equals("no")){
                break;
            }
        }
        for (RegistrationForm reg : regs) {
            System.out.printf("%s %s %d\n" ,reg.fullname, reg.phone, reg.age);
        }
    }
}
