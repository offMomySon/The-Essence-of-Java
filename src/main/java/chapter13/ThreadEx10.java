package chapter13;

public class ThreadEx10 implements Runnable {
  public static boolean autoSave = false;

  public static void main(String[] args) {
    Thread thread = new Thread(new ThreadEx10());
    thread.setDaemon(true);
    thread.start();

    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (i == 3) {
        autoSave = true;
      }
    }

    System.out.println("프로그램을 종료합니다.");
  }


  @Override
  public void run() {

    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (autoSave) {
        autoSave();
      }
    }
  }

  public void autoSave() {
    System.out.println("작업 파일이 자동 저장되었습니다.");
  }
}

