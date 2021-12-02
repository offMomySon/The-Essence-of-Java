package chapter12;


enum Transportation {

  BUS(100) {
    public int fare(int distance) {
      return this.BASIC_FARE * distance;
    }
  },
  TRAIN(150) {
    public int fare(int distance) {
      return this.BASIC_FARE * distance;
    }
  },
  SHIP(100) {
    public int fare(int distance) {
      return this.BASIC_FARE * distance;
    }
  },
  AIRPLANE(300) {
    public int fare(int distance) {
      return this.BASIC_FARE * distance;
    }
  };


  protected final int BASIC_FARE;

  Transportation(int basicFare) {
    this.BASIC_FARE = basicFare;
  }

  public int getBasicFare() {
    return this.BASIC_FARE;
  }

  abstract int fare(int distance);
}

public class EnumEx3 {
  public static void main(String[] args) {
    System.out.println("bus fare = " + Transportation.BUS.fare(100));
    System.out.println("train fare = " + Transportation.TRAIN.fare(100));
    System.out.println("ship fare = " + Transportation.SHIP.fare(100));
    System.out.println("airplane fare = " + Transportation.AIRPLANE.fare(100));
  }
}
