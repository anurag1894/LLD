package Leave;

public abstract class Approver {
    protected Approver nextApprover;

    void setNextApprover(Approver approver) {
         this.nextApprover = approver;
    }

    void processLeaveApprover(int leaveDays) {};
}
