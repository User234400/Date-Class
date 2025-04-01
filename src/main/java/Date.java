import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getter methods
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setters (for updating the date)
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Step 2: isValidDate method
    public boolean isValidDate() {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = {31, (isLeapYear() ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return day <= daysInMonth[month - 1];
    }

    // Step 3: isLeapYear method
    public boolean isLeapYear() {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    // Step 4: updateDate method
    public void updateDate(int d, int m, int y) {
        if (d < 1 || m < 1 || m > 12 || y < 1) {
            System.out.println("Invalid date.");
            return;
        }

        int[] daysInMonth = {31, (isLeapYear() ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (d <= daysInMonth[m - 1]) {
            this.day = d;
            this.month = m;
            this.year = y;
        } else {
            System.out.println("Invalid date.");
        }
    }

    // Step 5: getDayOfWeek method
    public String getDayOfWeek() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return daysOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    // Step 6: calculateDifference method
    public int calculateDifference(Date otherDate) {
        Calendar cal1 = new GregorianCalendar(this.year, this.month - 1, this.day);
        Calendar cal2 = new GregorianCalendar(otherDate.year, otherDate.month - 1, otherDate.day);
        long diffMillis = Math.abs(cal1.getTimeInMillis() - cal2.getTimeInMillis());
        return (int) (diffMillis / (1000 * 60 * 60 * 24)); // Convert milliseconds to days
    }

    // Step 7: printDate method
    public void printDate() {
        String[] months = {
                "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"
        };
        System.out.println(months[month - 1] + " " + day + ", " + year);
    }

    // Step 8: compareTo method for sorting
    @Override
    public int compareTo(Date otherDate) {
        if (this.year != otherDate.year) {
            return this.year - otherDate.year;
        }
        if (this.month != otherDate.month) {
            return this.month - otherDate.month;
        }
        return this.day - otherDate.day;
    }
}
