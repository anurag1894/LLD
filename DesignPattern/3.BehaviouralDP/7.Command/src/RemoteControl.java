public class RemoteControl {
    Icommand icommand;
    public RemoteControl() {}
    public void setCommand(Icommand icommand) {
        this.icommand = icommand;
    }
    public void setButton() {
        icommand.execute();
    }
}
