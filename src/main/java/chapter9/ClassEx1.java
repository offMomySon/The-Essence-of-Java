package chapter9;

final class Card1 {
  String kind;
  int num;

  public Card1() {
    this("SPADE", 1);
  }

  public Card1(String kind, int num) {
    this.kind = kind;
    this.num = num;
  }

  @Override
  public String toString() {
    return "Card1{" +
        "kind='" + kind + '\'' +
        ", num=" + num +
        '}';
  }
}

public class ClassEx1 {
  public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
    Card1 card1 = Card1.class.newInstance();
    Class<?> card11 = Class.forName("chapter9.Card1");
    Card1 card12 = new Card1("HEART", 3);

    Class cObj = card12.getClass();

    System.out.println("=====================");
    System.out.println(card1);
    System.out.println(card11);
    System.out.println(card12);
    System.out.println("=====================");

    System.out.println(cObj.getName());
    System.out.println(cObj.toGenericString());
    System.out.println(cObj.toString());
    System.out.println("=====================");

  }
}
