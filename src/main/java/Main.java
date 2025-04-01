import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Date> dateList = new ArrayList<>();

        // Menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a Date");
            System.out.println("2. Update a Date");
            System.out.println("3. Print Day of Week");
            System.out.println("4. Calculate Difference Between Dates");
            System.out.println("5. Sort Dates");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();

            // Handling different menu options without switch-case
            if (choice == 1) {
                // Add a Date
                System.out.println("Enter a date.");
                System.out.print("Enter day: ");
                int day = scanner.nextInt();
                System.out.print("Enter month: ");
                int month = scanner.nextInt();
                System.out.print("Enter year: ");
                int year = scanner.nextInt();

                Date newDate = new Date(day, month, year);
                if (newDate.isValidDate()) {
                    dateList.add(newDate);
                    System.out.println("Date added successfully.");
                } else {
                    System.out.println("Invalid date.");
                }
            } else if (choice == 2) {
                // Update a Date
                System.out.print("Enter the index of the date to update (0 to " + (dateList.size() - 1) + "): ");
                int indexToUpdate = scanner.nextInt();
                if (indexToUpdate >= 0 && indexToUpdate < dateList.size()) {
                    Date dateToUpdate = dateList.get(indexToUpdate);
                    System.out.print("Enter new day: ");
                    int newDay = scanner.nextInt();
                    System.out.print("Enter new month: ");
                    int newMonth = scanner.nextInt();
                    System.out.print("Enter new year: ");
                    int newYear = scanner.nextInt();
                    dateToUpdate.updateDate(newDay, newMonth, newYear);
                    System.out.println("Date updated.");
                } else {
                    System.out.println("Invalid index.");
                }
            } else if (choice == 3) {
                // Print Day of Week
                System.out.print("Enter the index of the date to get the day of the week (0 to " + (dateList.size() - 1) + "): ");
                int indexToCheck = scanner.nextInt();
                if (indexToCheck >= 0 && indexToCheck < dateList.size()) {
                    Date dateToCheck = dateList.get(indexToCheck);
                    System.out.println("Day of week: " + dateToCheck.getDayOfWeek());
                } else {
                    System.out.println("Invalid index.");
                }
            } else if (choice == 4) {
                // Calculate Difference Between Dates
                if (dateList.size() < 2) {
                    System.out.println("At least two dates are needed to calculate the difference.");
                } else {
                    System.out.print("Enter the index of the first date (0 to " + (dateList.size() - 1) + "): ");
                    int firstIndex = scanner.nextInt();
                    System.out.print("Enter the index of the second date (0 to " + (dateList.size() - 1) + "): ");
                    int secondIndex = scanner.nextInt();
                    if (firstIndex >= 0 && firstIndex < dateList.size() && secondIndex >= 0 && secondIndex < dateList.size()) {
                        Date firstDate = dateList.get(firstIndex);
                        Date secondDate = dateList.get(secondIndex);
                        int diff = firstDate.calculateDifference(secondDate);
                        System.out.println("Difference between the two dates: " + diff + " days.");
                    } else {
                        System.out.println("Invalid indices.");
                    }
                }
            } else if (choice == 5) {
                // Sort Dates
                System.out.println("Sorting the dates...");
                Collections.sort(dateList);
                System.out.println("Sorted Dates:");
                for (Date d : dateList) {
                    d.printDate();
                }
            } else if (choice == 6) {
                // Exit
                running = false;
                System.out.println("Exiting program.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
