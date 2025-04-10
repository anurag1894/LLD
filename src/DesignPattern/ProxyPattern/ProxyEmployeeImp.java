package ProxyPattern;

public class ProxyEmployeeImp implements EmployeeDao{
    EmployeeDao employeeDao;

    ProxyEmployeeImp(){
        this.employeeDao = new EmployeeImp();
    }


    @Override
    public void create(Client client, EmployeeDo employeeDo) throws Exception {
        if(Client.ADMIN.equals(client)){
            employeeDao.create(client,employeeDo);
            return ;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void delete(Client client, int employeeId) throws Exception {
        if(Client.ADMIN.equals(client)){
            employeeDao.delete(client,employeeId);
            return ;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public EmployeeDo get(Client client, int employeeId) throws Exception {
        if(Client.ADMIN.equals(client) || Client.USER.equals(client)){
            return employeeDao.get(client,employeeId);

        }
        throw new Exception("Access Denied");
    }
}
