public class TestDoubleDataType {
    public static void main(String[] args) {
        double total = 1.1;
        for (int i = 0; i < 100; i++) {
            total += 1.1;
        }
        System.out.println("total = " + total);
    }
}
