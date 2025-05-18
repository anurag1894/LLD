package EmployeeManagment;

public class EmployeeMgmtFacade {
    Employee employee;
    Department department;
    Payroll payroll;

    LeaveMgmt leaveMgmt;

    public EmployeeMgmtFacade(Employee employee) {
        this.employee = employee;
        this.department = new Department();
        this.payroll = new Payroll();
        this.leaveMgmt = new LeaveMgmt();
    }


     public void registerEmployee(String  name, String dept){
        employee.showDetails();
        payroll.calculateSalary(employee);
        department.assignToDepartment(employee,dept);
     }

     public void applyLeave(int days){
        leaveMgmt.applyLeave(employee,days);
     }
}
