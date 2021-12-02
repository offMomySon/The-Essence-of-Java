package chapter11;

import java.util.Stack;

public class StackEx1 {
  public static Stack back = new Stack();
  public static Stack forward = new Stack();

  public static void main(String[] args) {
    goURL("1.네이버");
    goURL("2. 야후");
    goURL("3. 네이버");
    goURL("4. 다음");

    printStatus();

    goBack();
    System.out.println("= 뒤로가기 버튼을 누른후 =");
    printStatus();

    goBack();
    System.out.println("= 뒤로가기 버튼을 누른후 =");
    printStatus();

    goForward();
    System.out.println("= 앞으로 가기 버튼을 누른후 =");
    printStatus();

    goURL("sdjflksdjflk");
    System.out.println("새로운 주소 이동후 ");
    printStatus();
  }

  public static void printStatus() {
    System.out.println("back : " + back);
    System.out.println("forward : " + forward);
    System.out.println("현재 화면은 : " + back.peek());
    System.out.println();
  }

  public static void goURL(String url) {
    back.push(url);
    if (!forward.empty()) {
      forward.clear();
    }
  }

  public static void goForward() {
    if (!forward.empty()) {
      back.push(forward.pop());
    }
  }

  public static void goBack() {
    if (!back.empty()) {
      forward.push(back.pop());
    }
  }

}
