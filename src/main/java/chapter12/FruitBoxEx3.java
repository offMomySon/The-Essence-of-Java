package chapter12;

class Juice {
  private final String name;

  public Juice(String name) {
    this.name = name;
  }

  public String toString() {
    return name + " juice";
  }
}

class Juicer {
  public static Juice makeJuice(FruitBox<? extends Fruit2> box) {
    String name = "";

    for (Fruit2 fruit : box.getList()) {
      name += fruit.toString() + " ";
    }
    return new Juice(name);
  }
}

public class FruitBoxEx3 {
  public static void main(String[] args) {
    FruitBox<Fruit2> fruitBox = new FruitBox<>();
    FruitBox<Apple2> appleBox = new FruitBox();

    fruitBox.add(new Apple2());
    fruitBox.add(new Grape2());
    appleBox.add(new Apple2());
    appleBox.add(new Apple2());

    System.out.println(Juicer.makeJuice(fruitBox));
    System.out.println(Juicer.makeJuice(appleBox));
  }
}
