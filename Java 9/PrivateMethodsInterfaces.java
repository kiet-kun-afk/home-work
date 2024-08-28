public interface PrivateMethodsInterfaces {

    // public methods có thể triển khai lại trong lớp
    void publicMethods();

    // private methods không thể triển khai lại trong lớp, chỉ có thể gọi bên trong interface
    private void privateMethods() {
        System.out.println("private methods");
    }

    default void defaultMethods() {
        System.out.println("default methods");
        privateMethods(); // sử dụng private methods
    }
}