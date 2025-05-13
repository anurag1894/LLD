package StudentExample;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(25, "Monika", "Banglore");

        /*
        This is for traditional way to create object But it will point to same object
         */
        Student cloneStudentTraditional = student;
        student.name += " & Anurag";
        System.out.println(cloneStudentTraditional.name);
        student.name ="Monika";

        /*
        This is using Proto DP way to create object But it will point to different and new object
         */
        Student cloneStudentProtoDP = (Student) student.clone();
        student.name += " & Anurag";
        System.out.println(cloneStudentProtoDP.name);
    }
}
