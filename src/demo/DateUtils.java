package demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author: heyong
 */
public class DateUtils {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 9, 23);
        LocalDate saturday = date.with(DayOfWeek.SATURDAY);
//        System.out.println(saturday);

        int i = 0;
        while (i < 10) {
//            System.out.println(saturday.minusWeeks(i));
            i++;
        }

        System.out.println(-12 % 5);
    }


}
