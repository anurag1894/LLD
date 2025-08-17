package DW.command;

import DW.enums.TransactionStatus;
import DW.enums.TransactionType;
import DW.model.Transaction;
import DW.model.Wallet;

import java.util.ArrayList;
import java.util.List;

public class TransactionInvoker {
    List<Transaction> transactions;
    List<WalletCommand> commands;

    public TransactionInvoker(){
        transactions = new ArrayList<Transaction>();
        commands = new ArrayList<>();
    }
    public void process(WalletCommand walletCommand) {
        walletCommand.execute();
        commands.add(walletCommand);
    }

    public void processTransactions(Transaction transaction, Wallet wallet) {
        WalletCommand command = null;
        switch (transaction.getTransactiontype()) {
            case ADD_MONEY:
                command = new AddMoney(wallet, transaction.getAmount());
                break;
            case WITHDRAW_MONEY:
                command = new WithdrawMoney(wallet, transaction.getAmount());
                break;
        }
        if (command != null) {
            process(command);
        }
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        transactions.add(transaction);
    }

    public void processTransactions(Transaction transaction, Wallet walletSender,Wallet walletReceiver) {
        WalletCommand command = new TransferMoney(walletSender, walletReceiver, transaction.getAmount());
        process(command);
        transaction.setTransactionStatus(TransactionStatus.COMPLETED);
        transactions.add(transaction);
    }



    public void rollBackLastTransaction() {
      WalletCommand lastCommand = commands.get(commands.size() - 1);
      lastCommand.rollback();
    }
}
