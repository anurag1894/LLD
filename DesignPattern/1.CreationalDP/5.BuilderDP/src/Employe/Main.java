package Employe;

public class Main {
    public static void main(String[] args) {
        EmployeeBuilder builder = new ManagerEmployee();
        EmployeeDirector director = new EmployeeDirector(builder);
        Employee employee = director.construct();
        System.out.println(employee);

    }
}
