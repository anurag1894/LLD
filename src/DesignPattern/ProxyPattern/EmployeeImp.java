package ProxyPattern;

public class EmployeeImp implements EmployeeDao{
    @Override
    public void create(Client client, EmployeeDo employeeDo){
        System.out.println("creating employee in DB");
    }
    @Override
    public void delete(Client client, int employeeId){
        System.out.println("deleting employee from DB");
    }

    @Override
    public EmployeeDo get(Client client, int employeeId){
        System.out.println("getting employee from db");
        return  new EmployeeDo();
    }
}
