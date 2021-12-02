package chapter11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetLotto {
  public static void main(String[] args) {
    Set set = new HashSet();

    for (int i = 0; set.size() < 6; i++) {
      set.add((int) (Math.random() * 45 + 1));
    }

    List list = new LinkedList(set);
    System.out.println(list);

    List test = new LinkedList();
    test.add(1);
    test.add(1);
    test.add(1);
    test.add(1);
    test.add(1);

    int arr[] = {4, 33, 24, 15, 17, 21};
    System.out.print("====================================");
    Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(integers, Collections.reverseOrder());
    for (int i : integers) {
      System.out.print("[" + i + "]");
    }

    System.out.print("====================================");

    List<Integer> collect = Arrays.stream(arr).boxed().sorted((a, b) -> -1 * a.compareTo(b)).collect(Collectors.toList());

    System.out.print("====================================");
    arr = Arrays.stream(arr).boxed().sorted((a, b) -> -1 * a.compareTo(b)).mapToInt(a -> a).toArray();
    for (int i : arr) {
      System.out.print("[" + i + "]");
    }
    System.out.print("====================================");

    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list);

    Collections.sort(list, new Descending2());
    System.out.println(list);
  }
}

class Descending2 implements Comparator {

  @Override
  public int compare(Object o1, Object o2) {
    Integer n = (Integer) o1;
    Integer n2 = (Integer) o2;
    return n.compareTo(n2);
  }
}
