package com.example;

import jakarta.transaction.Transactional;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class BankService {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Transactional
    public void transferMoney(int fromAcc, int toAcc, double amount) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Account sender = session.get(Account.class, fromAcc);
            Account receiver = session.get(Account.class, toAcc);

            if (sender.getBalance() < amount) {
                throw new RuntimeException("Insufficient funds");
            }

            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            session.update(sender);
            session.update(receiver);

            Transaction txn = new Transaction();
            txn.setFromAccount(fromAcc);
            txn.setToAccount(toAcc);
            txn.setAmount(amount);
            txn.setTimestamp(new java.util.Date());

            session.save(txn);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Transaction failed: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
