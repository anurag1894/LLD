package Leave;

import StudentExample.Student;

public class Main {
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        Approver CEO = new ceo();
        manager.setNextApprover(director);
        director.setNextApprover(CEO);

        manager.processLeaveApprover(4);
        manager.processLeaveApprover(10);
        manager.processLeaveApprover(18);
        manager.processLeaveApprover(45);

    }
}
