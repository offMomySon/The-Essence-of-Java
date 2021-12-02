package chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapEx4 {
  public static void main(String[] args) {
    String[] datas = {"A", "K", "A", "K", "D", "K", "A", "K", "k", "K", "K", "Z", "D"};

    Map map = new HashMap();

    for (String data : datas) {
      if (map.containsKey(data)) {
        Integer value = (Integer) map.get(data);
        map.put(data, Integer.valueOf(value + 1));
      } else {
        map.put(data, Integer.valueOf(1));
      }
    }

    Iterator iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      int value = ((Integer) entry.getValue()).intValue();
      System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
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
