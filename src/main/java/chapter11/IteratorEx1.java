package chapter11;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx1 {

  public static void main(String[] args) {
    ArrayList arr = new ArrayList();
    arr.add("1");
    arr.add("2");
    arr.add("3");
    arr.add("4");
    arr.add("5");

    Iterator it = arr.iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
    }


  }
}
