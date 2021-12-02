package chapter9;

import java.util.StringTokenizer;

public class StringTokenizerEx2 {
  public static void main(String[] args) {
    String expression = "x=100*(200+300)/2";
    StringTokenizer stringTokenizer = new StringTokenizer(expression, "=*(+)/", true);

    while (stringTokenizer.hasMoreTokens()) {
      System.out.println(stringTokenizer.nextToken());
    }

  }
}
