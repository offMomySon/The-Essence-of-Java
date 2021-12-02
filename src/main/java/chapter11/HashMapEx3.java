package chapter11;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx3 {
  public static Map phoneBook = new HashMap();

  public static void main(String[] args) {
    addPhoneNumber("친구", "이자바6", "010-6111-1111");
    addPhoneNumber("친구", "이자바5", "010-5111-1111");
    addPhoneNumber("친구", "이자바4", "010-4111-1111");
    addPhoneNumber("회사", "이자바1", "010-3111-1111");
    addPhoneNumber("회사", "이자바2", "010-2111-1111");
    addPhoneNumber("회사", "이자바3", "010-1111-1111");
    addPhoneNumber("세탁", "010-7111-1111");

    printList();
  }

  public static void addPhoneNumber(String groupName, String name, String tel) {
    addGroup(groupName);
    Map group = (HashMap) phoneBook.get(groupName);
    group.put(name, tel);
  }

  public static void addPhoneNumber(String name, String tel) {
    addPhoneNumber("기타", name, tel);
  }

  public static void addGroup(String groupName) {
    if (phoneBook.containsKey(groupName)) {
      return;
    }
    phoneBook.put(groupName, new HashMap());
  }

  public static void printList() {
    Set set = phoneBook.entrySet();
    Iterator it = set.iterator();

    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry) it.next();

      Set group = ((Map) entry.getValue()).entrySet();
      System.out.println("  *  " + entry.getKey() + "[" + group.size() + "]");

      Iterator iterator = group.iterator();
      while (iterator.hasNext()) {
        Map.Entry user = (Map.Entry) iterator.next();
        System.out.println("user name : " + user.getKey() + ", tel : " + user.getValue());
      }
      System.out.println();
    }
  }
}
