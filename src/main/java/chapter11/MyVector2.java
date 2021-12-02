package chapter11;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyVector2 extends MyVector implements Iterator {
  int lastRet = -1;
  int cursor = 0;

  @Override
  public void remove() {
    if (lastRet == -1) {
      throw new IllegalStateException();
    }

    remove(lastRet);
    lastRet = -1;
    cursor--;
  }

  @Override
  public boolean hasNext() {
    return cursor < size();
  }

  @Override
  public Object next() {
    Object item = get(cursor);
    lastRet = cursor;
    cursor++;
    return item;
  }

  public Iterator iterator() {
    lastRet = -1;
    cursor = 0;
    return this;
  }

  @Override
  public String toString() {
    String result = "";
    Iterator it = iterator();

    for (int i = 0; it.hasNext(); i++) {
      if (i != 0) {
        result += ", ";
      }
      result += it.next();
    }

    return "[" + result + "]";
  }
}
