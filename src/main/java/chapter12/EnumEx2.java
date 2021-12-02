package chapter12;

enum Direction2 {
  EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

  private static final Direction2[] DIRS = Direction2.values();

  private final int value;
  private final String symbol;

  private Direction2(int value, String symbol) {
    this.value = value;
    this.symbol = symbol;
  }

  public int getValue() {
    return this.value;
  }

  public String getSymbol() {
    return this.symbol;
  }

  public static Direction2 of(int index) {
    if (index < 1 || index >= DIRS.length) {
      throw new IllegalArgumentException("Invalid value : " + index);
    }

    return DIRS[index - 1];
  }

  public Direction2 rotate(int num) {
    num = num % 4;

    if (num < 0) {
      num += 4;
    }

    return DIRS[(value - 1 + num) % 4];
  }

}

public class EnumEx2 {
  public static void main(String[] args) {
    for (Direction2 dir : Direction2.values()) {
      System.out.printf("%s = %d \n", dir.name(), dir.getValue());
    }

    Direction2 d1 = Direction2.EAST;
    Direction2 d2 = Direction2.of(1);

    System.out.printf("d1 = %s, %d \n", d1.name(), d1.getValue());
    System.out.printf("d2 = %s, %d \n", d2.name(), d2.getValue());

    System.out.println(Direction2.EAST.rotate(1));
    System.out.println(Direction2.EAST.rotate(2));
    System.out.println(Direction2.EAST.rotate(-1));
    System.out.println(Direction2.EAST.rotate(-2));
  }
}
