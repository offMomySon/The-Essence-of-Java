package chapter8;

public class FinallyTest3 {

  public static void main(String[] args) {
    method1();
    System.out.println("method1() 의 수행을 마치고 main 이 실행됩니다.");
  }

  static void method1() {
    try {
      System.out.println("method() 가 호출되었습니다.");
      return;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.out.println("method1 의 finally 가 실행되었습니다.");
    }
  }

}
