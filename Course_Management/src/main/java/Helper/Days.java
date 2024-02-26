/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class Days {

    public static String MONDAY = "Monday";
    public static String TUESDAY = "Tuesday";
    public static String WEDNESDAY = "Wednesday";
    public static String THURSDAY = "Thursday";
    public static String FRIDAY = "Friday";
    public static String SATURDAY = "Saturday";
    public static String SUNDAY = "Sunday";

    public static String formatDays(List<String> days) {
        return String.join(",", days);
    }

    public static List<String> convertDaysStringToList(String days) {
        String[] strArray = days.split(",");
        List<String> strList = Arrays.asList(strArray);
        return strList;
    }
}
