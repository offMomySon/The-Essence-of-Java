package chapter11;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {

  public Object push(Object obj) {
    addElement(obj);
    return obj;
  }

  public Object peek() {
    int len = size();

    if (len == 0) {
      throw new EmptyStackException();
    }

    return elementAt(len - 1);
  }

  public Object pop() {
    Object item = peek();

    removeElement(size() - 1);
    return item;
  }

  public boolean empty() {
    return size() == 0;
  }

  public int search(Object o) {
    int i = lastIndexOf(o);

    if (i >= 0) {
      return size() - i;
    }
    return -1;
  }

}
