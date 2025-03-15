package ir.sampleJFR.annotation;

import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;

@Name("ir.sampleJFR.annotation.TransactionBlocked")
@Severity(80)
@Label("Transaction Blocked")
public class TransactionBlocked extends Event {

    @TransactionId
    @Label(value="Transaction")
    private long transaction;

    @TransactionId
    @Label("Transaction Blocker")
    private long transactionBlocker;

    public void setTransaction(long transaction) {
        this.transaction = transaction;
    }

    public void setTransactionBlocker(long transactionBlocker) {
        this.transactionBlocker = transactionBlocker;
    }
}
