class Student {
    int rollNo;// instance variable
    String name;
    // static String college = "BBDIT";
    static String college = "BBDIT";// static variable

    // constructor
    Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    // method to display the values
    void display() {
        System.out.println(rollNo + " " + name + " " + college);
    }
}

// Test class to show the values of objects
public class TestStaticVariable1 {
    @SuppressWarnings("static-access")
    public static void main(String args[]) {
        Student s1 = new Student(111, "Karan");
        Student s2 = new Student(222, "Aryan");
        s1.college = "SIT";
        s2.college = "ITS";
        // we can change the college of all objects by the single line of code
        // Student.college="BBDIT";
        s1.display();
        s2.display();
    }
}