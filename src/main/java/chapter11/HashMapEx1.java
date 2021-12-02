package chapter11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapEx1 {
  public static void main(String[] args) {
    Map map = new HashMap();
    map.put("myId", "1234");
    map.put("myId1", "1234");
    map.put("myId2", "1234");

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("id 와 password 를 입력해주세요.");
      System.out.print("id : ");
      String id = sc.nextLine().trim();

      if (!map.containsKey(id)) {
        System.out.println("입력한 id 가 없습니다. 다시 입력해주세요.");
        continue;
      }

      System.out.print("pw : ");
      String password = sc.nextLine().trim();

      if (map.get(id).equals(password)) {
        System.out.println("id , pw 일치합니다. 종료합니다.");
        break;
      }

      System.out.println("pw 가 일치하지 않습니다.");
    }


  }
}
