package EmployeeManagment;

public class Employee {
    private String name;

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    private String designation;
    public Employee(String name, String designation){
        this.name = name;
        this.designation = designation;
    }
    public void showDetails(){
        System.out.println("Employee: "+this.name + " is : "+this.designation);
    }
}
