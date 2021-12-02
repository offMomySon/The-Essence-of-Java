package chapter11;

public class MyVector {
  Object[] data = null;
  int capacity = 0;
  int size = 0;

  public MyVector(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity);
    }
    this.capacity = capacity;
    data = new Object[capacity];
  }

  public MyVector() {
    this(10);
  }

  public void ensureCapacity(int minCapacity) {
    if (minCapacity - this.capacity < 0) {
      return;
    }
    setCapacity(minCapacity);
  }

  public boolean add(Object obj) {
    ensureCapacity(this.capacity + 1);
    data[size++] = obj;
    return true;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
    }
    return data[index];
  }

  public Object remove(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("범위를 벗어 났습니다.");
    }
    Object old = data[index];
    if (size - 1 != index) {
      System.arraycopy(data, index + 1, data, index, size - index - 1);
    }
    data[size - 1] = null;
    size--;
    return old;
  }

  public boolean remove(Object target) {
    for (int i = 0; i < size; i++) {
      if (target.equals(data[i])) {
        remove(i);
        return true;
      }
    }
    return false;
  }

  public void clear() {
    for (int i = 0; i < size; i++) {
      data[i] = null;
    }
    size = 0;
  }

  public Object[] toArray() {
    Object[] result = new Object[size];
    System.arraycopy(result, 0, data, 0, size);
    return result;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int capacity() {
    return capacity;
  }

  public int size() {
    return size;
  }

  private void setCapacity(int capacity) {
    if (this.capacity == capacity) {
      return;
    }

    Object[] tmp = new Object[capacity];
    System.arraycopy(data, 0, tmp, 0, size);
    data = tmp;
    this.capacity = capacity;
  }

  
}
