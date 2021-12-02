package chapter5;

public class ArrayEx8 {

  public static void main(String[] args) {
    int[] bal1 = new int[45];

    for (int i = 0; i < bal1.length; i++) {
      bal1[i] = i + 1;
    }

    int temp = 0;
    int j = 0;

    for (int i = 0; i < 6; i++) {
      j = (int) (Math.random() * 45);
      temp = bal1[i];
      bal1[i] = bal1[j];
      bal1[j] = temp;
    }

    for (int i = 0; i < 6; i++) {
      System.out.printf("ball [%d] = %d%n", i, bal1[i]);
    }

  }

}
