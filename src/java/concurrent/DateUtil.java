package concurrent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: chenjianhu
 * @Date: 2020/7/13 18:16
 */
public class DateUtil {

    private final static DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final static DateTimeFormatter weekFormatter = DateTimeFormatter.ofPattern("YYYY-w");

    private final static DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

    public static final int TWO_DAY = 2 * 24 * 60 * 60;

    public static final int TWENTY_DAY = 20 * 24 * 60 * 60;

    public static final int FORTY_DAY = 40 * 24 * 60 * 60;

    public static final int EIGHT_HOUR_SECOND = 60 * 60 * 8;// 8小时

    public static final int FOREVER = -1;

    public static String getDay() {
        return LocalDate.now().format(dayFormatter);
    }

    public static String getWeek() {
        return LocalDate.now().format(weekFormatter);
    }

    public static String getMonth() {
        return LocalDate.now().format(monthFormatter);
    }


    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM");
        System.out.println(LocalDate.now().format(dateTimeFormatter));
    }
}
