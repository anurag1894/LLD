package Employe;

public class EmployeeDirector {
    private EmployeeBuilder builder;
    public EmployeeDirector(EmployeeBuilder builder){
        this.builder = builder;
    }
    public Employee construct(){
        builder.setID();
        builder.setName();
        builder.setAddress();
        return  builder.build();
    }
}
