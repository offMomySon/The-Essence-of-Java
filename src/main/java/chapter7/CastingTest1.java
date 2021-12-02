package chapter7;

public class CastingTest1 {

  public static void main(String[] args) {
    Car car = null;
    FireEngine fireEngine = new FireEngine();
    FireEngine fireEngine2 = null;

    fireEngine.water();

    car = fireEngine;
//    car.water();
    fireEngine2 = (FireEngine) car;
    fireEngine2.water();
  }
}

class Car {

  String color;
  int door;

  public void drive() {
    System.out.println("drive, Brrrr~");
  }

  public void stop() {
    System.out.println("stop!!!");
  }
}

class FireEngine extends Car {

  void water() {
    System.out.println("water!!!");
  }
}



