package Employe;

public interface EmployeeBuilder {
    void setID();
    void setName();
    void setAddress();
    Employee build();
}
