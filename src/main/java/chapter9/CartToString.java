package chapter9;

class Card {
  String kind;
  int number;

  public Card() {
    this("SPADE", 1);
  }

  public Card(String kind, int number) {
    this.kind = kind;
    this.number = number;
  }

}

public class CartToString {
  public static void main(String[] args) {
    Card card1 = new Card();
    Card card2 = new Card();

    System.out.println(card1.toString());
    System.out.println(card2.toString());

  }

}
