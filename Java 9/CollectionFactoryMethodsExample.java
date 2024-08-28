import java.util.List;

public class CollectionFactoryMethodsExample {
    public static void main(String[] args) {
        // can't change
        List<String> colors = List.of("red", "green", "blue", "yellow", "black");
        // example: add to list -> error
        // colors.add("white");
        System.out.println(colors);
    }
}
