package chapter11;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {
  public static void main(String[] args) {
    ArrayList original = new ArrayList();
    ArrayList copy1 = new ArrayList();
    ArrayList copy2 = new ArrayList();

    for (int i = 0; i < 10; i++) {
      original.add(i + "");
    }

    Iterator iterator = original.iterator();

    while (iterator.hasNext()) {
      copy1.add(iterator.next());
    }

    System.out.println(" = original 에서 copy 로 복사 = ");
    System.out.println(original);
    System.out.println(copy1);

    iterator = original.iterator();

    while (iterator.hasNext()) {
      copy2.add(iterator.next());
      iterator.remove();
    }

    System.out.println(" = original 에서 copy1 로 복사, 삭제");
    System.out.println(original);
    System.out.println(copy2);
  }
}
