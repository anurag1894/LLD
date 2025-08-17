package DW.command;

import DW.model.Wallet;

public class WithdrawMoney implements WalletCommand {
    Wallet wallet;
    int amount;

    public WithdrawMoney(Wallet wallet, int amount) {
        this.wallet = wallet;
        this.amount = amount;
    }

    @Override
    public void execute() {
        wallet.subBalance(amount);
    }

    @Override
    public void rollback() {
        wallet.subBalance(-amount);
    }
}
