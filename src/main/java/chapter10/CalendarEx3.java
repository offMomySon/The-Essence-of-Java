package chapter10;


import java.util.Calendar;

public class CalendarEx3 {
  public static void main(String[] args) {

    final int[] TIME_UNIT = {3600, 60, 1};
    final String[] TIME_UNIT_NAME = {"시간", "분", "초"};

    Calendar date1 = Calendar.getInstance();
    Calendar date2 = Calendar.getInstance();

    date1.set(Calendar.HOUR_OF_DAY, 10);
    date1.set(Calendar.MINUTE, 20);
    date1.set(Calendar.SECOND, 30);

    date2.set(Calendar.HOUR_OF_DAY, 20);
    date2.set(Calendar.MINUTE, 30);
    date2.set(Calendar.SECOND, 10);

    System.out.println(
        "time1 : " + date1.get(Calendar.HOUR_OF_DAY) + " 시" + date1.get(Calendar.MINUTE) + " 분 "
            + date1.get(Calendar.SECOND) + " 초.");
    System.out.println(
        "time2 : " + date2.get(Calendar.HOUR_OF_DAY) + " 시" + date2.get(Calendar.MINUTE) + " 분 "
            + date2.get(Calendar.SECOND) + " 초.");

    long difference = (Math.abs(date1.getTimeInMillis() - date2.getTimeInMillis())) / 1000;
    System.out.println("두 시간의 차이는 " + difference + " 초 입니다.");

    String tmp = "";
    for (int i = 0; i < TIME_UNIT.length; i++) {
      tmp += difference / TIME_UNIT[i] + TIME_UNIT_NAME[i];
      difference %= TIME_UNIT[i];
    }
    System.out.println("시 분초 변환하면 " + tmp + "입니다.");
  }


}
