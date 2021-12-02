package chapter6;

public class VarArgsEx {

  public static void main(String[] args) {
    String[] strArr = {"100", "200", "300"};

    System.out.println(concatenate("", "100", "200", "300"));
    System.out.println(concatenate(1, "-", strArr));
    System.out.println(concatenate(1, ",", new String[]{"1", "2,", "3"}));

  }

  static String concatenate(int n, String delim, String... args) {
    String result = "";

    for (String str : args) {
      result += str + delim;
    }
    return result;
  }

  static String concatenate(String... args) {
    return concatenate(1, "", args);
  }


}
