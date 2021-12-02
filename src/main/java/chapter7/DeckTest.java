package chapter7;

public class DeckTest {

  public static void main(String[] args) {
    Deck d = new Deck();
    Card c = d.pick(0);
    System.out.println(c);

    d.shuffle();
    c = d.pick(0);
    System.out.println(c);
  }

}

class Deck {

  public static final int CARD_NUM = 52;
  public Card[] cards = new Card[CARD_NUM];

  public Deck() {
    int i = 0;

    for (int j = Card.KIND_MAX; j > 0; j--) {
      for (int k = 0; k < Card.NUM_MAX; k++) {
        cards[i++] = new Card(j, k + 1);
      }
    }
  }

  public Card pick() {
    int index = (int) (Math.random() * CARD_NUM);

    return cards[index];
  }

  public Card pick(int index) {
    return cards[index];
  }

  void shuffle() {
    for (int i = 0; i < cards.length; i++) {
      int r = (int) (Math.random() * CARD_NUM);

      Card temp = cards[r];
      cards[r] = cards[i];
      cards[i] = temp;
    }
  }


}

class Card {

  public static final int KIND_MAX = 4;
  public static final int NUM_MAX = 13;

  public static final int SPADE = 4;
  public static final int DIAMOND = 3;
  public static final int HEART = 2;
  public static final int CLOVER = 1;

  int kind;
  int number;

  public Card() {
    this(SPADE, 1);
  }

  public Card(int kind, int number) {
    this.kind = kind;
    this.number = number;
  }

  public String toString() {
    String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
    String numbers = "0123456789XJQK";
    return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(number);
  }


}


