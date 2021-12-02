package chapter11;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
  static Queue q = new LinkedList();
  static final int MAX_VALUE = 5;

  public static void main(String[] args) {
    System.out.println("help 를 입력하면 도움말을 입력받을 수 있습니다.");

    while (true) {
      System.out.println(">>");

      Scanner s = new Scanner(System.in);
      String input = s.nextLine().trim();

      if ("".equals(input)) {
        continue;
      }

      if (input.equalsIgnoreCase("q")) {
        System.exit(0);
      }

      if (input.equalsIgnoreCase("help")) {
        System.out.println(" help - 도움말을 보여줍니다. ");
        System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
        System.out.println(" history - 최근에 입력한 명령어를 최대 : " + MAX_VALUE + " 개 보여줍니다.");
      } else if (input.equalsIgnoreCase("history")) {
        int i = 0;

        save(input);

        LinkedList cmds = (LinkedList) q;
        ListIterator listIterator = cmds.listIterator();
        while (listIterator.hasNext()) {
          System.out.println(++i + ". " + listIterator.next());
        }

      } else {
        save(input);
        System.out.println(input);
      }
    }
  }

  public static void save(String cmd) {
    q.offer(cmd);

    if (q.size() > MAX_VALUE) {
      q.remove();
    }
  }

}
