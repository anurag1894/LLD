package Employe;

public class ManagerEmployee implements EmployeeBuilder{
    private int id;
    private String name;
    private  String address;

    @Override
    public void setID() {
        id= 1;
    }

    @Override
    public void setName() {
        name = "Gaurav";
    }

    @Override
    public void setAddress() {
        address = "Delhi";
    }

    @Override
    public Employee build() {
        return new Employee(id,name,address);
    }

}
