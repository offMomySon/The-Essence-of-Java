package chapter13;

public class ThreadEx4 {
  public static void main(String[] argsa) {
    long start = System.currentTimeMillis();

    for (int i = 0; i < 300; i++) {
      System.out.print(new String("-"));
    }
    System.out.println();
    System.out.println("총 소요된 시간 : " + (System.currentTimeMillis() - start));

    start = System.currentTimeMillis();

    for (int i = 0; i < 300; i++) {
      System.out.print(new String("|"));
    }
    System.out.println();
    System.out.println("총 소요된 시간 : " + (System.currentTimeMillis() - start));

  }
}
