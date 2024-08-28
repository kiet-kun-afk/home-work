import java.util.Scanner;

/**
 * Hasse's Algorithm
 */
public class HasseAlg {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("--------------------------------");
        int count = 0;
        Scanner sc = new Scanner(System.in);
        long result = sc.nextInt();
        while (result != 1) {
            System.out.print(result + " ");
            if (result % 2 == 0) {
                count++;
                result = result / 2;
            } else {
                count++;
                result = 3 * result + 1;
            }
        }
        System.out.println(result);
        System.out.println();
        System.out.println("Count: " + count);
    }
}