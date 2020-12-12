package guess;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Calendar;
import java.util.Date;
public class ForDemo {
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    //private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(sdf.format(date));

       // Calendar cal = Calendar.getInstance();
        //System.out.println(sdf.format(cal.getTime()));

        //LocalDateTime now = LocalDateTime.now();
       // System.out.println(dtf.format(now));




        for (int i = 0; i < 10; i++) {
            System.out.println("count " + i);
        }
    }
}
