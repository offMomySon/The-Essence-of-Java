package chapter8;

public class ExceptionEx17 {

  public static void main(String[] args) {

    try {
      int n = method1();

      System.out.println("method1() 이 종료 되었습니다. 반환값 : " + n);

    } catch (RuntimeException e) {
      System.out.println("method1() 의 Exception 예외를 main() 에서 처리합니다.");
      e.printStackTrace();
    }

  }

  public static int method1() {
    try {
      System.out.println("method1 처리중..");
      throw new Exception();
    } catch (RuntimeException re) {
      System.out.println("RuntimeException 이 발생했습니다. !!");
      return 0;
    } catch (Exception e) {
      System.out.println("Exception 에러가 발생했습니다. !!");
      throw new MyException("my");
//      return 0;
    } finally {
      System.out.println("method1() 의 finally 작업이 실행되었습니다.");
    }

//    return 1;
  }
}

class MyException extends RuntimeException {

  public MyException(String string) {
    super(string);
  }
}

