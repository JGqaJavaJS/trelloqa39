package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesUtils {

    public String getDateString() {
        // Create a Date object representing the current date and time
        Date currentDate = new Date();

        // Define a date format pattern
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");

        return dateFormat.format(currentDate);
    }
}
