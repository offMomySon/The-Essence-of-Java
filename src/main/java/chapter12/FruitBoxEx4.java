package chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Fruit4 {
  private int weight;
  private String name;

  public int getWeight() {
    return weight;
  }

  public String getName() {
    return name;
  }

  public Fruit4(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public String toString() {
    return name + "<" + weight + ">";
  }
}

class Apple4 extends Fruit4 {
  public Apple4(String name, int weight) {
    super(name, weight);
  }
}

class Grape4 extends Fruit4 {
  public Grape4(String name, int weight) {
    super(name, weight);
  }
}

class AppleCmp implements Comparator<Apple4> {
  @Override
  public int compare(Apple4 a1, Apple4 a2) {
    int weight = a1.getWeight();
    int weight2 = a2.getWeight();

    return -1 * Integer.compare(weight, weight2);
  }
}

class GrapeCmp implements Comparator<Grape4> {
  @Override
  public int compare(Grape4 g1, Grape4 g2) {
    int weight = g1.getWeight();
    int weight1 = g2.getWeight();

    return -1 * Integer.compare(weight, weight1);
  }
}

class FruitCmp implements Comparator<Fruit4> {
  @Override
  public int compare(Fruit4 f1, Fruit4 f2) {
    int weight = f1.getWeight();
    int weight1 = f2.getWeight();
    return Integer.compare(weight, weight1);
  }
}

class FruitBox4<T extends Fruit4> extends Box4<T> {
}

class Box4<T> {
  private final ArrayList<T> list = new ArrayList();

  public ArrayList<T> getList() {
    return list;
  }

  public void add(T f) {
    list.add(f);
  }

  public T get(int index) {
    return list.get(index);
  }

  public int size() {
    return list.size();
  }

  public String toString() {
    return list.toString();
  }
}

public class FruitBoxEx4 {
  public static void main(String[] args) {
    FruitBox4<Apple4> appleBox = new FruitBox4();
    FruitBox4<Grape4> grapeBox = new FruitBox4();

    appleBox.add(new Apple4("GreenApple", 100));
    appleBox.add(new Apple4("GreenApple", 200));
    appleBox.add(new Apple4("GreenApple", 300));

    grapeBox.add(new Grape4("GreenGrape", 400));
    grapeBox.add(new Grape4("GreenGrape", 300));
    grapeBox.add(new Grape4("GreenGrape", 200));

    Collections.sort(appleBox.getList(), new AppleCmp());
    Collections.sort(grapeBox.getList(), new GrapeCmp());
    System.out.println(appleBox);
    System.out.println(grapeBox);
    System.out.println();
    Collections.sort(appleBox.getList(), new FruitCmp());
    Collections.sort(grapeBox.getList(), new FruitCmp());
    System.out.println(appleBox);
    System.out.println(grapeBox);
  }
}
