package ProxyPattern;

public class ProxyPattern {
    public static void main(String args[]) {
        try {
            EmployeeDao employeeDao = new ProxyEmployeeImp();
            employeeDao.create(Client.ADMIN, new EmployeeDo());
            employeeDao.get(Client.USER, 1);
            employeeDao.delete(Client.ADMIN, 1);
        } catch (Exception e) {
            System.out.println("Maybe User Not Admin");
        }


        try {
            EmployeeDao employeeDao = new ProxyEmployeeImp();
            employeeDao.create(Client.USER, new EmployeeDo());
            employeeDao.get(Client.USER, 1);
            employeeDao.delete(Client.ADMIN, 1);
        } catch (Exception e) {
            System.out.println("Maybe User Not Admin");
        }
    }
}
