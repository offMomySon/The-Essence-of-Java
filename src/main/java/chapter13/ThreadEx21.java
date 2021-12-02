package chapter13;

public class ThreadEx21 {
  public static void main(String[] args) {
    ThreadEx21_1 threadEx21_1 = new ThreadEx21_1();
    Thread thread = new Thread(threadEx21_1);
    Thread thread2 = new Thread(threadEx21_1);

    thread.start();
    thread2.start();

  }
}

class Account {
  private int balance = 1000;

  public int getBalance() {
    return this.balance;
  }

  public synchronized void withdraw(int money) {
//    synchronized(this){
    if (balance >= money) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      balance -= money;
    }
//    }
  }
}

class ThreadEx21_1 implements Runnable {
  private Account account = new Account();

  @Override
  public void run() {
    while (account.getBalance() > 0) {
      int money = (int) (Math.random() * 3 + 1) * 100;
      account.withdraw(money);
      System.out.println("Current money - " + account.getBalance());
    }
  }
}





