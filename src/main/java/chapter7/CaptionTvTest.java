package chapter7;

class Tvv {

  boolean power;
  int channel;

  void power() {
    power = !power;
  }

  void channelUp() {
    ++channel;
  }

  void channelDown() {
    --channel;
  }
}

class CaptionTv extends Tvv {

  boolean caption;

  void displayCation(String text) {
    if (caption) {
      System.out.println(text);
    }
  }
}

public class CaptionTvTest {

  public static void main(String[] args) {
    CaptionTv ctv = new CaptionTv();
    ctv.channel = 10;
    ctv.channelUp();
    System.out.println(ctv.channel);

    ctv.displayCation("hello world");
    ctv.caption = true;
    ctv.displayCation("hello World");

  }

}
