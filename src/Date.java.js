
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
}

public boolean isValidDate() {
    if (month < 1 || month > 12 || day < 1 || day > 31) {
        return false;
    }
    int[] daysInMonth = {31, (isLeapYear() ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    return day <= daysInMonth[month - 1];
}

private boolean isLeapYear() {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}

public void updateDate(int d, int m, int y) {
    if (d < 1 || m < 1 || m > 12 || y < 0) {
        System.out.println("Invalid date!");
        return;
    }
    this.day = d;
    this.month = m;
    this.year = y;
    if (!isValidDate()) {
        System.out.println("Invalid date!");
        return;
    }
}

public String getDayOfWeek() {
    Calendar calendar = new GregorianCalendar(year, month - 1, day);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    switch (dayOfWeek) {
        case Calendar.SUNDAY: return "Sunday";
        case Calendar.MONDAY: return "Monday";
        case Calendar.TUESDAY: return "Tuesday";
        case Calendar.WEDNESDAY: return "Wednesday";
        case Calendar.THURSDAY: return "Thursday";
        case Calendar.FRIDAY: return "Friday";
        case Calendar.SATURDAY: return "Saturday";
        default: return "Unknown";
    }
}

public int calculateDifference(Date otherDate) {
    Calendar calendar1 = new GregorianCalendar(year, month - 1, day);
    Calendar calendar2 = new GregorianCalendar(otherDate.year, otherDate.month - 1, otherDate.day);
    long diffInMillis = Math.abs(calendar1.getTimeInMillis() - calendar2.getTimeInMillis());
    return (int) (diffInMillis / (1000 * 60 * 60 * 24));
}

public void printDate() {
    String[] monthNames = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    System.out.println(monthNames[month - 1] + " " + day + ", " + year);
}

@Override
public int compareTo(Date otherDate) {
    if (this.year != otherDate.year) {
        return this.year - otherDate.year;
    } else if (this.month != otherDate.month) {
        return this.month - otherDate.month;
    } else {
        return this.day - otherDate.day;
    }
}
}
