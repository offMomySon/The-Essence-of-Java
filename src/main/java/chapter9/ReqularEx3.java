package chapter9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReqularEx3 {
  public static void main(String[] args) {
    String source = "HP:011-1111-1111, HOME:02-999-9999";
    String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

    Pattern compile = Pattern.compile(pattern);
    Matcher matcher = compile.matcher(source);

    int i = 0;

    while (matcher.find()) {
      System.out.println(
          ++i + " : " + matcher.group() + " -> " + matcher.group(0) + "," + matcher.group(1) + ","
              + matcher.group(2));
    }

  }

}
