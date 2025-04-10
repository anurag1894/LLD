package ProxyPattern;

public interface EmployeeDao {
    public void create(Client client, EmployeeDo employeeDo) throws Exception;
    public void delete(Client client, int employeeId) throws Exception;
    public EmployeeDo get(Client client, int employeeId) throws Exception;

}
