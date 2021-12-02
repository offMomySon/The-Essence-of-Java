package chapter10;

import java.util.Calendar;

public class CalendarEx1 {
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance();

    System.out.println("년도 : " + calendar.get(Calendar.YEAR));
    System.out.println("월(0-11) : " + calendar.get(Calendar.MONTH));
    System.out.println("이 해의 몇 째 주 : " + calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("이 달의 몇 째 주 : " + calendar.get(Calendar.WEEK_OF_MONTH));
    System.out.println("이 달의 몇 일 : " + calendar.get(Calendar.DATE));
    System.out.println("이 달의 몇 일 : " + calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println("이 해의 몇 일 : " + calendar.get(Calendar.DAY_OF_YEAR));

    System.out.println("요일 ( 1-7 ) 1: 일요일 : " + calendar.get(Calendar.DAY_OF_WEEK));

    System.out.println("이달의 몇 번 쨰 요일: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    System.out.println("오전_오후 (0 : 오전, 1: 오후) : " + calendar.get(Calendar.AM_PM));

    System.out.println("시간(0-11) : " + calendar.get(Calendar.HOUR));
    System.out.println("시간(0-23) : " + calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("분 : " + calendar.get(Calendar.MINUTE));
    System.out.println("초 : " + calendar.get(Calendar.SECOND));
    System.out.println("1000 분의 1초 (0~999) : " + calendar.get(Calendar.MILLISECOND));

    System.out
        .println("TimeZone (-12~+12) : " + calendar.get(Calendar.ZONE_OFFSET) / (60 * 60 * 1000));
    System.out.println("이달의 마지막 날 : " + calendar.getActualMaximum(Calendar.DATE));


  }

}
