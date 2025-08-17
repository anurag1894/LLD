package DW.command;

public interface WalletCommand {
    public void execute();
    public void rollback();
}
