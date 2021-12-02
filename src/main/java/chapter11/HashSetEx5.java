package chapter11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx5 {
  public static void main(String[] args) {
    Set setA = new HashSet();
    Set setB = new HashSet();
    Set setHab = new HashSet();
    Set setCha = new HashSet();
    Set setKyo = new HashSet();

    setA.add("1");
    setA.add("2");
    setA.add("3");
    setA.add("4");
    setA.add("5");
    System.out.println("A = " + setA);

    setB.add("4");
    setB.add("5");
    setB.add("6");
    setB.add("7");
    setB.add("8");
    System.out.println("B = " + setB);

    Iterator it = setA.iterator();
    while (it.hasNext()) {
      Object next = it.next();
      if (setB.contains(next)) {
        setKyo.add(next);
      }
    }

    it = setA.iterator();
    while (it.hasNext()) {
      Object next = it.next();
      if (!setB.contains(next)) {
        setCha.add(next);
      }
    }

    it = setA.iterator();
    while (it.hasNext()) {
      setHab.add(it.next());
    }

    it = setB.iterator();
    while (it.hasNext()) {
      setHab.add(it.next());
    }

    System.out.println("A U B = " + setHab);
    System.out.println("A and B = " + setKyo);
    System.out.println("A - B = " + setCha);
  }
}
