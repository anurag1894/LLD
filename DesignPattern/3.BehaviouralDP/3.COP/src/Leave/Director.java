package Leave;

public class Director extends Approver{
    @Override
    void processLeaveApprover(int leaveDays){
        if (leaveDays < 16){
            System.out.println("Director Approved");
        }else{
            this.nextApprover.processLeaveApprover(leaveDays);
        }
    }
}
