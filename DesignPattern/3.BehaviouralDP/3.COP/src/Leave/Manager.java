package Leave;

public class Manager extends Approver {
    @Override
    void processLeaveApprover(int leaveDays){
        if(leaveDays<7){
            System.out.println("Manager approved");
        }else{
            this.nextApprover.processLeaveApprover(leaveDays);
        }
    }
}
