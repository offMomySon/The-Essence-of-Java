package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class CollectionsEx {
  public static void main(String[] args) {
    List list = new ArrayList();
    System.out.println(list);

    Collections.addAll(list, 1, 2, 3, 4, 5);
    System.out.println(list);

    Collections.rotate(list, 2);
    System.out.println(list);

    Collections.swap(list, 0, 2);
    System.out.println(list);

    Collections.shuffle(list);
    System.out.println(list);

    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list);

    int idx = Collections.binarySearch(list, 3);
    System.out.println("index of 3 = " + idx);

    System.out.println("max  = " + Collections.max(list));
    System.out.println("min = " + Collections.min(list));
    System.out.println("max = " + Collections.max(list, Collections.reverseOrder()));

    Collections.fill(list, 9);
    System.out.println("list = " + list);

    List newList = Collections.nCopies(list.size(), 2);
    System.out.println("newList = " + newList);

    System.out.println(Collections.disjoint(list, newList));

    Collections.copy(list, newList);
    System.out.println("lsit = " + list);
    System.out.println("newList = " + newList);

    Collections.replaceAll(list, 2, 1);
    System.out.println("list = " + list);

    Enumeration enumeration = Collections.enumeration(list);
    ArrayList lsit2 = Collections.list(enumeration);

    System.out.println("list2 = " + lsit2);

  }

}
