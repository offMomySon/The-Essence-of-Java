package chapter9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReqularEx1 {
  public static void main(String[] args) {
    String[] datas = {"bat", "baaby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};

    Pattern compile = Pattern.compile("c[a-z]*");

    for (String data : datas) {
      Matcher matcher = compile.matcher(data);

      if (matcher.matches()) {
        System.out.println(data + ", ");
      }
    }

  }
}
