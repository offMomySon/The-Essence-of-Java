package chapter11;

import java.util.Iterator;

public class MyVector2Test {

  public static void main(String[] args) {
    MyVector2 vector = new MyVector2();
    vector.add("0");
    vector.add("1");
    vector.add("2");
    vector.add("3");
    vector.add("4");

    System.out.println("삭제 전 : " + vector);
    Iterator it = vector.iterator();
    it.next();
    it.remove();
    it.next();
    it.remove();

    System.out.println("삭제 후 : " + vector);
  }

}
