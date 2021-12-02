package chapter6;

public class TvTest4 {

  public static void main(String[] args) {
    Tv[] tvArr = new Tv[3];

    for (int i = 0; i < tvArr.length; i++) {
      tvArr[i] = new Tv();
      tvArr[i].channel = 10 + i;
    }

    for (int i = 0; i < tvArr.length; i++) {
      tvArr[i].channelUp();
      System.out.printf("tvArr[%d].channel : %d", i, tvArr[i].channel);
    }
  }
}

class Tv {

  String color;
  boolean power;
  int channel;

  void power() {
    power = !power;
  }

  void channelUp() {
    channel++;
  }

  void channelDown() {
    channel--;
  }

}


