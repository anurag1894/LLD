package EmployeeManagment;

public class Department {
    public void assignToDepartment(Employee employee, String dept){
        System.out.println("Assigned "+ employee.getName() + " with "+employee.getDesignation() +" is in dept "+ dept);
    }
}
