package Leave;

public class ceo extends Approver{
    @Override
    void processLeaveApprover(int leaveDays){
        if(leaveDays<30){
            System.out.println("CEO approved");
        }else{
            System.out.println("These days are not approval");
        }
    }
}
