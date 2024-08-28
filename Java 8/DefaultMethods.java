public interface DefaultMethods {
    // abstract
    void abstractMethod();

    // default
    default void defaultMethod() {
        System.out.println("This is a default method");
    }
}
