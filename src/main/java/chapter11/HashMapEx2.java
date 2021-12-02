package chapter11;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx2 {
  public static void main(String[] args) {
    Map map = new HashMap();
    map.put("김자바", new Integer(90));
    map.put("김자바", new Integer(100));
    map.put("이자바", new Integer(100));
    map.put("강자바", new Integer(80));
    map.put("안자바", new Integer(90));

    Set set = map.entrySet();
    Iterator it = set.iterator();

    while (it.hasNext()) {
      Map.Entry e = (Map.Entry) it.next();
      System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
    }

    Set keys = map.keySet();
    System.out.println("참가자 명단 : " + keys);

    int total = 0;
    Collection c = map.values();

    it = c.iterator();

    while (it.hasNext()) {
      total += (Integer) it.next();
    }

    System.out.println("총합 : " + total);
    System.out.println("평균 : " + (float) total / map.size());
    System.out.println("최고점수 : " + Collections.max(c));
    System.out.println("최저점수 : " + Collections.min(c));

  }

}
