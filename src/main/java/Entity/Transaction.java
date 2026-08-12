package Entity;

import java.time.LocalDateTime;

public class Transaction {
    private final String sender;
    private final String receiver;
    private final int amount;
    private final LocalDateTime createdAt;

    public Transaction(String sender, String receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }
}
