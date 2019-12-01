/*
 * 
 */
package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private double balance;
    private Lock lock;
    private Condition condition;
    
    public Bank(double amount) { 
        balance = amount; 
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }
    
    /**
     * @return the balance of the account.
     */
    public double getBalance() { return balance; }
    
    /**
     * Deposits a given amount to the user's balance. This method does not
     * handle racing conditions or deadlocks.
     * @param amount is the amount to be added.
     */
    public void flawedDeposit(double amount) {
        //System.out.println("Depositing: "+amount);
        double newBalance = balance+amount;
        for (int i = 0; i < 100000; i++) { } //waste time
        balance = newBalance;
        System.out.println("After deposit: "+balance);
    }
    
    /**
     * Withdraws a given amount from the user's balance. This method does not
     * handle racing conditions or deadlocks.
     * @param amount is the amount to be withdrawn.
     */
    public void flawedWithdraw(double amount) {
        //System.out.println("Withdrawing: "+amount);
        double newBalance = balance-amount;
        for (int i = 0; i < 100000; i++) { } //waste time
        balance = newBalance;
        System.out.println("After withdrawing: "+balance);
    }
    
    /**
     * Deposits a given amount to the user's balance. This method handles
     * racing condition through synchronization but does not handle deadlocks.
     * @param amount is the amount to be added.
     */
    public synchronized void syncDeposit(double amount) {
        double newBalance = balance+amount;
        for (int i = 0; i < 100000; i++) { } //waste time
        balance = newBalance;
        System.out.println("After deposit: "+balance);
    }
    
    /**
     * Withdraws a given amount from the user's balance. This method handles
     * racing condition through synchronization but does not handle deadlocks.
     * @param amount is the amount to be withdrawn.
     */
    public synchronized void syncWithdraw(double amount) {
        while(balance < amount) { } //wait until equation is changed
        double newBalance = balance-amount;
        for (int i = 0; i < 100000; i++) { } //waste time
        balance = newBalance;
        System.out.println("After withdrawing: "+balance);
        
    }
    
    /**
     * Deposits a given amount to the user's balance. This method handles
     * racing condition through synchronization block but does not handle 
     * deadlocks.
     * @param amount is the amount to be added.
     */
    public void syncBlockDeposit(double amount) {
        synchronized(this) {
            double newBalance = balance+amount;
            for (int i = 0; i < 100000; i++) { } //waste time
            balance = newBalance;
            System.out.println("After deposit: "+balance);
        }
    }
    
    /**
     * Withdraws a given amount from the user's balance. This method handles
     * racing condition through synchronization block but does not handle 
     * deadlocks. This does not check if amount withdrawn greater than the
     * balance.
     * @param amount is the amount to be withdrawn.
     */
    public void syncBlockWithdraw(double amount) {
        synchronized(this) {
            double newBalance = balance-amount;
            for (int i = 0; i < 100000; i++) { } //waste time
            balance = newBalance;
            System.out.println("After withdrawing: "+balance);
        }
    }
    
    /**
     * Deposits a given amount to the user's balance. This method handles
     * racing condition and deadlock through use of wait and notifyAll.
     * @param amount is the amount to be added.
     */
    public synchronized void waitAndNotifyDeposit(double amount) {
        double newBalance = balance+amount;
        for (int i = 0; i < 100000; i++) { } //waste time
        balance = newBalance;
        System.out.println("After deposit: "+balance);
        notifyAll();
    }
    
    /**
     * Withdraws a given amount from the user's balance. This method handles
     * racing condition deadlocks through use of wait and notifyAll.
     * @param amount is the amount to be withdrawn.
     */
    public synchronized void waitAndNotifyWithdraw(double amount) {
        try {
            while(balance < amount)
                wait();
            double newBalance = balance-amount;
            for (int i = 0; i < 100000; i++) { } //waste time
            balance = newBalance;
            System.out.println("After withdrawing: "+balance);
        }
        catch(InterruptedException e) { 
            System.out.println("Error in WaitAndNotifyWithdraw");
        }
    }
    
    /**
     * Deposits a given amount to the user's balance. This method handles
     * racing condition through synchronization and deadlocks through use
     * of lock and unlock.
     * @param amount is the amount to be added.
     */
    public void lockAndUnlockDeposit(double amount) {
        lock.lock();
        try {
            double newBalance = balance+amount;
            for (int i = 0; i < 100000; i++) { } //waste time
            balance = newBalance;
            System.out.println("After deposit: "+balance);
            condition.signalAll();
        }
        finally { lock.unlock(); }
    }
    
    /**
     * Withdraws a given amount from the user's balance. This method handles
     * racing condition through synchronization and deadlocks through use
     * of lock and unlock.
     * @param amount is the amount to be withdrawn.
     */
    public void lockAndUnlockWithdraw(double amount) {
        lock.lock();
        try {
            while(balance < amount)
                condition.await();
            double newBalance = balance-amount;
            for (int i = 0; i < 100000; i++) { } //waste time
            balance = newBalance;
            System.out.println("After withdrawing: "+balance);
        }
        catch(InterruptedException e) { 
            System.out.println("Error in lockAndUnlockWithdraw");
        }
        finally { lock.unlock(); }
    }
}