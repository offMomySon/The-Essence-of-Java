package chapter10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx3 {
  public static void main(String[] args) {
    DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
    DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

    try {
      Date parse = df.parse("2015년 10월 6일");
      System.out.println(df2.format(parse));

    } catch (ParseException e) {
      e.printStackTrace();
    }


  }
}
