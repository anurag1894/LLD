package DW.command;

import DW.model.Wallet;

public class TransferMoney implements WalletCommand {
    Wallet walletSender;
    Wallet walletReceiver;
    int amount;

    public TransferMoney(Wallet walletSender, Wallet walletReceiver, int amount) {
        this.walletSender = walletSender;
        this.walletReceiver = walletReceiver;
        this.amount = amount;
    }


    @Override
    public void execute() {
        walletReceiver.addBalance(amount);
        walletSender.subBalance(amount);
    }

    @Override
    public void rollback() {
        walletSender.subBalance(-amount);
        walletReceiver.addBalance(-amount);
    }
}
