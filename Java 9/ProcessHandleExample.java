public class ProcessHandleExample {

    public static void main(String[] args) {
        // object for current process
        ProcessHandle currentProcess = ProcessHandle.current();
        // output
        System.out.println("ID: " + currentProcess.pid());
        System.out.println("Is running: " + currentProcess.isAlive());
    }
}