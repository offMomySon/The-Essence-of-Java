package chapter7;

import java.util.LinkedList;
import java.util.List;

class Product {

  int price;
  int bonusPoint;

  public Product(int price) {
    this.price = price;
    this.bonusPoint = (int) (price / 10.0);
  }
}

class Tv2 extends Product {

  Tv2() {
    super(100);
  }

  public String toString() {
    return "tv";
  }
}

class Computer extends Product {

  public Computer() {
    super(200);
  }

  public String toString() {
    return "computer";
  }
}

class Audio extends Product {

  Audio() {
    super(50);
  }

  public String toString() {
    return "Audio";
  }
}

class Buyer {

  int money = 1000;
  int bonusPoint = 0;
  List<Product> products = new LinkedList<>();


  void buy(Product product) {
    if (money < product.price) {
      System.out.println("돈이 부족해서 못삼.");
      return;
    }

    money -= product.price;
    bonusPoint += product.bonusPoint;

    products.add(product);

    System.out.println(product + "을 구매하였습니다.");
  }

  void summary() {
    int sum = 0;
    String itemList = "";

    for (Product product : products) {
      sum += product.price;
      itemList += product.toString() + ", ";
    }

    System.out.println("구입하신 물건의 총 가격은 : " + sum + "입니다.");
    System.out.println("구입하신 제품은 : " + itemList + " 입니다.");
  }

  void refund(Product product) {
    if (products.remove(product)) {
      money += product.price;
      bonusPoint -= product.bonusPoint;
      System.out.println(product.toString() + " 을 반품하셨습니다.");
    } else {
      System.out.println("구매하신 제품중 해당 제품이 존재하지 않습니다.");
    }
  }
}

public class PolyArgumentTest {

  public static void main(String[] args) {
    Buyer b = new Buyer();
    Tv2 tv = new Tv2();
    Computer computer = new Computer();
    Audio audio = new Audio();

    b.buy(tv);
    b.buy(computer);
    b.buy(audio);
    b.summary();
    System.out.println();
    b.refund(computer);
    b.summary();


  }
}
