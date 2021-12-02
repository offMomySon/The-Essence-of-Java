package chapter4;

public class FlowEx22 {

  public static void main(String[] args) {
    int[] arr = {10, 20, 30, 40, 50};
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%d ", arr[i]);
    }
    System.out.println();

    for (int num : arr) {
      System.out.printf("%d ", num);
      sum += num;
    }
    System.out.println();

    System.out.println("sum = " + sum);
  }

}
