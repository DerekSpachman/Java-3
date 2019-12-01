/*
 * 
 * 
 * @author Derek Spachman
 */
package threads;


public class BankThread extends Thread{
    private Bank account;
    private double amount;
    private int choice;
    private final int NUMBER_OF_TIMES = 10;

    public BankThread(Bank account, double amount, int choice) {
        this.account = account;
        this.amount = amount;
        this.choice = choice;
    }

    /**
     * Calls the appropriate Bank method based on the choice attribute.
     */
    @Override
    public void run() {
        try {
            switch (choice) {
                case 1 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.flawedWithdraw(amount);
                        sleep(500);
                    }
                    break;
                case 2 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.flawedDeposit(amount);
                        sleep(500);
                    }
                    break;
                case 3 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.syncWithdraw(amount);
                        sleep(500);
                    }
                    break;
                case 4 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.syncDeposit(amount);
                        sleep(500);
                    }
                    break;
                case 5 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.syncBlockWithdraw(amount);
                        sleep(500);
                    }
                    break;
                case 6 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.syncBlockDeposit(amount);
                        sleep(500);
                    }
                    break;
                case 7 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.waitAndNotifyWithdraw(amount);
                        sleep(500);
                    }
                    break;
                case 8 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.waitAndNotifyDeposit(amount);
                        sleep(500);
                    }
                    break;
                case 9 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.lockAndUnlockWithdraw(amount);
                        sleep(500);
                    }
                    break;
                case 10 :
                    for (int i = 1; i <= NUMBER_OF_TIMES; i++) {
                        account.lockAndUnlockDeposit(amount);
                        sleep(500);
                    }
                    break;
            }
        }
        catch(InterruptedException e) { 
            System.out.println("Error with deposit thread."); 
        }
    }
    
    
    public static void main(String[] args) {
        Bank myBank = new Bank(0);
        BankThread thread1 = new BankThread(myBank, 100, 1);
        BankThread thread2 = new BankThread(myBank, 100, 2);
        //thread1.start();
        //thread2.start();
        
        //synchronized
        BankThread thread3 = new BankThread(myBank, 100, 3);
        BankThread thread4 = new BankThread(myBank, 100, 4);
        //thread3.start();
        //thread4.start();
        
        //synchronized blocks
        BankThread thread5 = new BankThread(myBank, 100, 5);
        BankThread thread6 = new BankThread(myBank, 100, 6);
        //thread5.start();
        //thread6.start();
        
        //wait and notifyAll
        BankThread thread7 = new BankThread(myBank, 100, 7);
        BankThread thread8 = new BankThread(myBank, 100, 8);
        //thread7.start();
        //thread8.start();
        
        //lock and unlockAll
        BankThread thread9 = new BankThread(myBank, 100, 9);
        BankThread thread10 = new BankThread(myBank, 100, 10);
        //thread9.start();
        //thread10.start();
    }
}