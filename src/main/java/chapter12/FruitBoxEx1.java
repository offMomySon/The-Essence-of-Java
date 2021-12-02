package chapter12;

import java.util.ArrayList;

class Fruit {
  public String toString() {
    return "Fruit";
  }
}

class Apple extends Fruit {
  public String toString() {
    return "Apple";
  }
}

class Grape extends Fruit {
  public String toString() {
    return "Grape";
  }
}

class Toy {
  public String toString() {
    return "TOY";
  }
}

public class FruitBoxEx1 {
  public static void main(String[] args) {
    Box<Fruit> fruitBox = new Box<Fruit>();
    Box<Apple> appleBox = new Box<Apple>();
    Box<Toy> toyBox = new Box<Toy>();
//    Box<Grape> graphBox = new Box<Apple>();

    fruitBox.add(new Fruit());
    fruitBox.add(new Apple());

    appleBox.add(new Apple());
    appleBox.add(new Apple());
//    appleBox.add(new Toy());

    toyBox.add(new Toy());
//    toyBox.add(new Apple());

    System.out.println(fruitBox);
    System.out.println(appleBox);
    System.out.println(toyBox);
  }
}

class Box<T> {
  public final ArrayList<T> list = new ArrayList<T>();

  public void add(T item) {
    list.add(item);
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