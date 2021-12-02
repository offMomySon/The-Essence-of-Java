package chapter10;

import java.util.Calendar;

public class CalendarEx2 {
  public static void main(String[] args) {
    final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};

    Calendar date1 = Calendar.getInstance();
    Calendar date2 = Calendar.getInstance();

    date1.set(2015, 7, 15);

    System.out.println(
        "date1 은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고.");
    System.out.println(
        "date2 은 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일 입니다.");

    long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
    System.out.println("date1 과 date2 의 시간 차이는 " + difference + " 초 입니다. ");

    System.out.println("date1 과 date2 의 일 차이는 " + difference / (24 * 60 * 60) + " 입니다.");
  }

  public static String toString(Calendar calendar) {
    return calendar.get(Calendar.YEAR) + " 년 " + (calendar.get(Calendar.MONTH) + 1) + " 월 "
        + calendar.get(Calendar.DATE) + " 일";
  }

}
