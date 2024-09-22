package tasks;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeTask {

    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.toString(); 
    }

    public long getCurrentTimeInMillis() {
        return System.currentTimeMillis();
    }

    public String getCurrentTimeInCities(String zone) {
        ZonedDateTime zoneTime = ZonedDateTime.now(ZoneId.of(zone));
        return zone + " : " + zoneTime.toString();
    }

    public String getWeekday(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        DayOfWeek dayOfWeek = instant.atZone(ZoneId.systemDefault()).getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public String getMonth(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        Month month = instant.atZone(ZoneId.systemDefault()).getMonth();
        return month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public int getYear(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);
        return instant.atZone(ZoneId.systemDefault()).getYear();
    }

}
