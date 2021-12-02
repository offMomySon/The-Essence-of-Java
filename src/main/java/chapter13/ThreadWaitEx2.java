package chapter13;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

enum Food2 {
  BURGER("burger"), DONUT("donut");

  public static int size = Food2.values().length;

  private String foodName;

  Food2(String foodName) {
    this.foodName = foodName;
  }
}

class Table2 {
  private final int MAX_FOOD = 6;
  private List<Food2> dishes = new LinkedList();

  private ReentrantLock lock = new ReentrantLock();
  private Condition forCook = lock.newCondition();
  private Condition forConsumer = lock.newCondition();

  public void add(Food2 food) {
    lock.lock();

    try {
      if (dishes.size() >= MAX_FOOD) {
        String name = Thread.currentThread().getName();
        System.out.println("Food is full. " + name + " is waiting..");
        try {
          forCook.await();
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return;
      }

      dishes.add(food);
      forConsumer.signal();
      System.out.println("Dishes : " + dishes.toString());
    } finally {
      lock.unlock();
    }
  }

  public void remove(Food2 food) {
    lock.lock();

    try {
      while (dishes.size() == 0) {
        String name = Thread.currentThread().getName();
        System.out.println("dish is empty. waiting .. " + name);
        try {
          forConsumer.await();
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      while (true) {
        for (int i = 0; i < dishes.size(); i++) {
          if (dishes.get(i).equals(food)) {
            dishes.remove(i);
            forCook.signal();
            return;
          }
        }

        try {
          String name = Thread.currentThread().getName();
          System.out.println("dish is empty. waiting .. " + name);
          forConsumer.await();
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } finally {
      lock.unlock();
    }
  }
}

class Customer2 implements Runnable {
  private Table2 table;
  private Food2 food;

  public Customer2(Table2 table, Food2 food) {
    this.table = table;
    this.food = food;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      String name = Thread.currentThread().getName();

      eat();
      System.out.println(name + " ate a " + food);
    }
  }

  public void eat() {
//    System.out.println("try eat food : " + food);
    table.remove(food);
  }
}

class Cook2 implements Runnable {

  private Table2 table;

  public Cook2(Table2 table) {
    this.table = table;
  }

  @Override
  public void run() {
    while (true) {
      makeFood();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void makeFood() {
    Food2[] foods = Food2.values();
    Food2 food = foods[(int) (Math.random() * Food2.size)];

//    System.out.println("make food : " + food);

    table.add(food);
  }

}

public class ThreadWaitEx2 {
  public static void main(String[] args) {
    Table2 table = new Table2();

    new Thread(new Cook2(table), "COOK1").start();
    new Thread(new Customer2(table, Food2.BURGER), "CUST1").start();
    new Thread(new Customer2(table, Food2.DONUT), "CUST2").start();

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.exit(0);
  }

}
