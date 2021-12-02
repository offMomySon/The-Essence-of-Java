package chapter13;

import java.util.LinkedList;
import java.util.List;

public class ThreadWaitEx1 {
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

class Table {
  private final int MAX_FOOD = 6;
  private List<Food2> dishes = new LinkedList();

  public synchronized void add(Food2 food) {
    if (dishes.size() >= MAX_FOOD) {
      String name = Thread.currentThread().getName();
      System.out.println("Food is full. " + name + " is waiting..");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return;
    }
    dishes.add(food);
    notify();
    System.out.println("Dishes : " + dishes.toString());
  }

  public boolean remove(Food food) {
    synchronized (this) {
      while (dishes.size() == 0) {
        String name = Thread.currentThread().getName();
        System.out.println("dish is empty. waiting .. " + name);
        try {
          wait();
//          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      for (int i = 0; i < dishes.size(); i++) {
        if (dishes.get(i).equals(food)) {
          dishes.remove(i);
          notify();
          return true;
        }
      }

      try {
        String name = Thread.currentThread().getName();
        System.out.println("dish is empty. waiting .. " + name);
        wait();
//        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return false;
  }
}

class Customer implements Runnable {
  private Table table;
  private Food food;

  public Customer(Table table, Food food) {
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

      if (eat()) {
        System.out.println(name + " ate a " + food);
      } else {
        System.out.println(name + " failed to eat. :<");
      }
    }
  }

  public boolean eat() {
//    System.out.println("try eat food : " + food);
    return table.remove(food);
  }
}

class Cook implements Runnable {
  private Table2 table;

  public Cook(Table2 table) {
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

enum Food {
  BURGER("burger"), DONUT("donut");

  public static int size = Food2.values().length;

  private String foodName;

  Food(String foodName) {
    this.foodName = foodName;
  }
}