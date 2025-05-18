package EmployeeManagment;



public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Anurag Jha", "L4");
        EmployeeMgmtFacade employeeMgmtFacade = new EmployeeMgmtFacade(employee);
        employeeMgmtFacade.registerEmployee("Anurag Jha", "AI");
        employeeMgmtFacade.applyLeave(10);
    }
}
