package chapter7;

class CardV2 {

  final int NUMBER;
  final String KIND;

  static int width = 100;
  static int height = 250;

  public CardV2() {
    this("HEART1", 1);
  }

  public CardV2(String kind, int num) {
    this.KIND = kind;
    this.NUMBER = num;
  }

  public String toString() {
    return KIND + " " + NUMBER;
  }
}

public class FinalCardTest {

  public static void main(String[] args) {
    CardV2 cardV2 = new CardV2();
//    cardV2.KIND = "not working";

    System.out.println(cardV2.KIND);
    System.out.println(cardV2.NUMBER);
    System.out.println(cardV2);

  }
}
