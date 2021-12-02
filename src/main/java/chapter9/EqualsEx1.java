package chapter9;

public class EqualsEx1 {
  public static void main(String[] args) {
    Value v1 = new Value(10);
    Value v2 = new Value(10);

    if (v1.equals(v2)) {
      System.out.println("v1 과 v2 는 같습니다.");
    } else {
      System.out.println("v1 과 v2 는 다릅니다.");
    }

  }

}

class Value {
  public int getValue() {
    return value;
  }

  int value;

  public Value(int value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (o != null && o instanceof Value) {
      return ((Value) o).getValue() == this.value;
    }
    
    return false;
  }
}
