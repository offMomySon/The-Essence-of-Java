package chapter9;

import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

public class StringEx5 {
  public static void main(String[] args) {
    String str = "가";

    byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
    byte[] bytes2 = str.getBytes(StandardCharsets.ISO_8859_1);

    System.out.println("UTF_8 : " + joinByteArr(bytes));
    System.out.println("ISO_8859 : " + joinByteArr(bytes2));

    System.out.println("UTF_8 : " + new String(bytes, StandardCharsets.UTF_8));
    System.out.println("ISO_8859 : " + new String(bytes2, StandardCharsets.ISO_8859_1));
  }

  public static String joinByteArr(byte[] bArr) {
    StringJoiner sj = new StringJoiner(":", "[", "]");

    for (byte b : bArr) {
      sj.add(String.format("%02X", b));
    }

    return sj.toString();
  }

}
