package chapter11;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx1 {
  public static void main(String[] args) {
    String[] datas = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};

    Map map = new TreeMap();

    for (String data : datas) {
      if (map.containsKey(data)) {
        map.put(data, Integer.valueOf(((Integer) map.get(data)) + 1));
      } else {
        map.put(data, Integer.valueOf(1));
      }
    }

    Iterator iterator = map.entrySet().iterator();
    System.out.println("= 기본 정렬 =");
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      int value = ((Integer) entry.getValue()).intValue();
      System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
    }

    Set set = map.entrySet();
    List list = new LinkedList(set);

    Collections.sort(list, new ValueComparator());

    iterator = list.iterator();
    System.out.println("= 값의 크기가 큰 순서대로 정렬 =");
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      int value = ((Integer) entry.getValue()).intValue();
      System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
    }

  }

  static class ValueComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
      if (!(o1 instanceof Map.Entry) || !(o2 instanceof Map.Entry)) {
        return -1;
      }

      Map.Entry m1 = (Map.Entry) o1;
      Map.Entry m2 = (Map.Entry) o2;

      int v1 = ((Integer) m1.getValue()).intValue();
      int v2 = ((Integer) m2.getValue()).intValue();

      return -1 * Integer.compare(v1, v2);
    }
  }

  public static String printBar(char ch, int value) {
    char[] bar = new char[value];
    for (int i = 0; i < value; i++) {
      bar[i] = ch;
    }
    return new String(bar);
  }
}

