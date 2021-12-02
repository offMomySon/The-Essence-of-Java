package chapter10;

import java.text.MessageFormat;

public class MessageFormatEx3 {

  public static void main(String[] args) throws Exception {
    String[] data = {
        "INSERT INTO CUST_INFO VALUES ('이자바', '02-123-1234', 27, '07-09')",
        "INSERT INTO CUST_INFO VALUES ('김프로', '032-333-1234', 33, '10-07')"
    };

    String pattern = "INSERT INTO CUST_INFO VALUES ({0}, {1}, {2}, {3})";
    MessageFormat messageFormat = new MessageFormat(pattern);

    for (String d : data) {
      Object[] parse = messageFormat.parse(d);

      for (Object s : parse) {
        System.out.println((String) s + ", ");
      }
      System.out.println();
    }

  }
}
