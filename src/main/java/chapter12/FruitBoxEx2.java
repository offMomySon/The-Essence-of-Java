package chapter12;

import java.util.ArrayList;

interface Eatable {
}

class Fruit2 implements Eatable {
  public String toString() {
    return "Fruit2";
  }
}

class Apple2 extends Fruit2 {
  public String toStirng() {
    return "Apple2";
  }
}

class Grape2 extends Fruit2 {
  public String toString() {
    return "Grape2";
  }
}

class Toy2 {
  public String toString() {
    return "Toy2";
  }
}

class FruitBox<T extends Fruit2 & Eatable> extends Box2<T> {
}

class Box2<T> {
  public final ArrayList<T> list = new ArrayList<T>();

  public ArrayList<T> getList() {
    return list;
  }
  
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

public class FruitBoxEx2 {
  public static void main(String[] args) {
    FruitBox<Fruit2> fruitBox = new FruitBox<Fruit2>();
    FruitBox<Apple2> appleBox = new FruitBox<Apple2>();
    FruitBox<Grape2> grapeBox = new FruitBox<Grape2>();
//    FruitBox<Grape2> grapeBox2 = new FruitBox<Apple2>();
//    FruitBox<Toy2> toyBox = new FruitBox<Toy2>();

    fruitBox.add(new Fruit2());
    fruitBox.add(new Grape2());
    fruitBox.add(new Apple2());
//    appleBox.add(new Grape2());
    appleBox.add(new Apple2());
    grapeBox.add(new Grape2());

    System.out.println(fruitBox);
    System.out.println(appleBox);
    System.out.println(grapeBox);
  }
}
