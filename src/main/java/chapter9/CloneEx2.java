package chapter9;

import java.util.Arrays;
import java.util.Stack;

public class CloneEx2 {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int[] arrClone = arr.clone();
    arrClone[0] = 6;

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arrClone));

    Book[] bookArr = {new Book(10), new Book(20), new Book(30), new Book(40)};
    Book[] clone = bookArr.clone();

    bookArr[1].page = 100;

    System.out.println(Arrays.toString(bookArr));
    System.out.println(Arrays.toString(clone));

    Name n1 = new Name("n1");
    Name n2 = n1.clone();

    n1.name = "change";

    System.out.println(n1.toString());
    System.out.println(n2.toString());
  }

}

class Name implements Cloneable {
  String name;

  @Override
  public String toString() {
    return "Name{" +
        "name='" + name + '\'' +
        '}';
  }

  public Name(String name) {
    this.name = name;
  }

  @Override
  protected Name clone() {
    Object obj = null;
    try {
      obj = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return (Name) obj;
  }
}

class Book implements Cloneable {
  int page;

  public Book(int page) {
    this.page = page;
  }

  @Override
  public Book clone() throws CloneNotSupportedException {
    return (Book) super.clone();
  }

  @Override
  public String toString() {
    return "Book{" +
        "page=" + page +
        '}';
  }
}