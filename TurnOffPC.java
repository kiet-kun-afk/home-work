import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

/**
 * TurnOffPC
 */
public class TurnOffPC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("TurnOffPC - Menu");
        System.out.println("1. Tắt máy ngay bây giờ");
        System.out.println("2. Tắt máy sau cơ số giây nhập vào");
        System.out.println("3. Đặt lịch tắt máy");
        System.out.println("4. Hủy lệnh tắt máy");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1:
                turnOffNow();
                break;
            case 2:
                setTimer(scanner);
                break;
            case 3:
                setSchedule(scanner);
                break;
            case 4:
                cancelSchedule();
                break;
            default:
                break;
        }
        scanner.close();
        System.exit(0);
    }

    @SuppressWarnings("deprecation")
    private static void turnOffNow() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("shutdown /s /t 0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PC will turn off immediately.");
    }

    @SuppressWarnings("deprecation")
    private static void turnOffAt(int seconds) {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("shutdown /s /t " + seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PC will turn off after " + seconds + " seconds.");
    }

    private static void setTimer(Scanner scanner) {
        // Prompt user to enter the number of seconds to wait before shutting down the PC
        System.out.print("Enter seconds: ");
        int seconds = scanner.nextInt();
        turnOffAt(seconds);
    }

    private static void setSchedule(Scanner scanner) {
        System.out.print("Enter date time (dd/MM/yyyy hh:mm:ss): ");
        String dString = scanner.nextLine().trim();
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(dString, dateTimeFormatter);
            LocalDateTime currentDateTime = LocalDateTime.now();
            if (currentDateTime.isBefore(localDateTime)) {
                long seconds = Duration.between(currentDateTime, localDateTime).getSeconds();
                turnOffAt((int) seconds);
            } else {
                System.out.println("Invalid date time. Please enter a future date time.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    private static void cancelSchedule() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("shutdown /a");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TurnOffPC scheduling has been canceled.");
    }
}