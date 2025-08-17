package DW.command;

import DW.model.Wallet;

public class AddMoney implements WalletCommand {
    private Wallet wallet;
    int amount;
    public AddMoney(Wallet wallet, int amount) {
        this.wallet = wallet;
        this.amount = amount;
    }


    @Override
    public void execute() {
        wallet.addBalance(amount);
    }

    @Override
    public void rollback() {
        wallet.addBalance(-amount);
    }
}
