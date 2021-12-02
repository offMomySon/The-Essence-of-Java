package chapter13;

public class ThreadEx20 {
  public static void main(String[] args) {
    ThreadEx20_1 gc = new ThreadEx20_1();
    gc.setDaemon(true);
    gc.start();

    int requiredMemory = 0;
    for (int i = 0; i < 20; i++) {
      requiredMemory = (int) (Math.random() * 10) * 20;

      if (gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
        System.out.println("start gc.");
        gc.interrupt();

        try {
          gc.join(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      gc.addMemory(requiredMemory);
      System.out.println("usedMemory : " + gc.getUsedMemory());
    }
  }
}

class ThreadEx20_1 extends Thread {
  private static final int MAX_MEMORY = 1000;
  private int usedMemory = 0;

  @Override
  public void run() {
    while (true) {

      try {
        Thread.sleep(1000 * 10);
      } catch (InterruptedException e) {
        System.out.println("interrupted.");
      }
      gc();
      System.out.println("Garbage Collected. Free Memory = " + freeMemory());
    }
  }

  private void gc() {
    usedMemory -= 300;
    if (usedMemory < 0) {
      usedMemory = 0;
    }
  }

  public int getUsedMemory() {
    return usedMemory;
  }

  public int totalMemory() {
    return MAX_MEMORY;
  }

  public int freeMemory() {
    return MAX_MEMORY - usedMemory;
  }

  public void addMemory(int memory) {
    usedMemory += memory;
  }

}
