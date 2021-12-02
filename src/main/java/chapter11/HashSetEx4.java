package chapter11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetEx4 {
  public static void main(String[] args) {
    Set set = new HashSet();

    set.add(new String("abc"));
    set.add(new String("abc"));
    set.add(new Person(10, "name"));
    set.add(new Person(10, "name"));

    System.out.println(set);

  }

}

class Person {
  private int age;
  private String name;

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return age;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Person)) {
      return false;
    }

    Person tmp = (Person) obj;
    return this.name.equals(tmp.getName()) && this.age == tmp.getAge();
  }

  public int hashCode() {
//    return (name+age).hashCode();
    return Objects.hash(name, age);
  }

  public String toString() {
    return name + " : " + age;
  }

}
