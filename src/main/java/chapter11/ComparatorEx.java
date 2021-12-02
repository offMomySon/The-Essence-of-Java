package chapter11;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
  public static void main(String[] args) {
    String[] strArr = {"cat", "Dog", "lion", "tiger"};
    char[] temp = {'a', 'b'};

    Arrays.sort(strArr);
    System.out.println("strArr = " + Arrays.toString(strArr));

    Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
    System.out.println("strArr = " + Arrays.toString(strArr));

    Arrays.sort(strArr, new Descending());
    System.out.println("strArr = " + Arrays.toString(strArr));
  }
}

class Descending implements Comparator {
  @Override
  public int compare(Object o1, Object o2) {
    if (!(o1 instanceof Comparable) || !(o2 instanceof Comparable)) {
      return -1;
    }
    Comparable c1 = (Comparable) o1;
    Comparable c2 = (Comparable) o2;

    return -1 * c1.compareTo(c2);
  }
}
