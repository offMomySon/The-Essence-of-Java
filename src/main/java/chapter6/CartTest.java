package chapter6;

public class CartTest {

  public static void main(String[] args) {
    System.out.println("Card.width : " + Card.width);
    System.out.println("Card.height : " + Card.height);

    Card c1 = new Card();
    c1.kind = "Hearts";
    c1.number = 7;

    Card c2 = new Card();
    c2.kind = "Spade";
    c2.number = 4;

    System.out.println(
        "c1 은 " + c1.kind + ", " + c1.number + " 이며, 크기는 (" + c1.width + ", " + c1.height
            + ") 이다.");
    System.out.println(
        "c2 는 " + c2.kind + ", " + c2.number + " 이며, 크기는 (" + c2.width + ", " + c2.height
            + ") 이다.");

    System.out.println("c1 의 width 와 height 를 각각 50, 80 으로 변경합니다.");
    c1.width = 50;
    c1.height = 80;

    System.out.println(
        "c1 은 " + c1.kind + ", " + c1.number + " 이며, 크기는 (" + c1.width + ", " + c1.height
            + ") 이다.");
    System.out.println(
        "c2 는 " + c2.kind + ", " + c2.number + " 이며, 크기는 (" + c2.width + ", " + c2.height
            + ") 이다.");
    
  }

}

class Card {

  String kind;
  int number;

  static int width = 100;
  static int height = 250;
}