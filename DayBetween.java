import java.util.Scanner;

public class DayBetween {

    public static int daysBetween(int day1, int month1, int year1, int day2, int month2, int year2) {
        // Validate inputs
        if (month1 < 1 || month1 > 12 || month2 < 1 || month2 > 12 || day1 < 1 || day2 < 1
                || day1 > getDaysInMonth(month1, year1) || day2 > getDaysInMonth(month2, year2)) {
            throw new IllegalArgumentException("Invalid date(s)");
        }

        // Calculate the total number of days for each date
        int totalDays1 = getTotalDaysSinceEpoch(day1, month1, year1);
        int totalDays2 = getTotalDaysSinceEpoch(day2, month2, year2);

        return totalDays2 - totalDays1;
    }

    // Method to calculate the total number of days since year 0 for a given date
    private static int getTotalDaysSinceEpoch(int day, int month, int year) {
        int totalDays = 0;

        // Add days for the years
        totalDays += (year - 1) * 365;
        totalDays += (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400; // Leap years

        // Add days for the months in the current year
        for (int i = 1; i < month; i++) {
            totalDays += getDaysInMonth(i, year);
        }

        // Add the days in the current month
        totalDays += day;

        return totalDays;
    }

    // Method to return the number of days in a given month of a specific year
    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    // Method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first date (dd/mm/yyyy): ");
            String date1 = scanner.nextLine();
            System.out.print("Enter the second date (dd/mm/yyyy): ");
            String date2 = scanner.nextLine();

            String[] parts1 = date1.split("/");
            int day1 = Integer.parseInt(parts1[0]);
            int month1 = Integer.parseInt(parts1[1]);
            int year1 = Integer.parseInt(parts1[2]);

            String[] parts2 = date2.split("/");
            int day2 = Integer.parseInt(parts2[0]);
            int month2 = Integer.parseInt(parts2[1]);
            int year2 = Integer.parseInt(parts2[2]);

            int daysBetween = daysBetween(day1, month1, year1, day2, month2, year2);

            System.out.println("daysBetween = " + daysBetween);
        }
    }
}
