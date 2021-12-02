package chapter6;

class Car {

  String color;
  String gearType;
  int door;

  Car() {
    this("white", "auto", 4);
  }

  Car(Car c) {
    this(c.color, c.gearType, c.door);
  }

  Car(String color, String gearType, int door) {
    this.color = color;
    this.gearType = gearType;
    this.door = door;
  }
}

public class CatTest3 {

  public static void main(String[] args) {
    Car car1 = new Car();
    Car car2 = new Car(car1);
    System.out.println(
        "c1 의 color = " + car1.color + ", gearType = " + car1.gearType + ", door = " + car1.door);
    System.out.println(
        "c2 의 color = " + car2.color + ", geartype = " + car2.gearType + ", door = " + car2.door);

    car1.door = 100;
    System.out.println("c1.door = 100 수행후");
    System.out.println(
        "c1 의 color = " + car1.color + ", gearType = " + car1.gearType + ", door = " + car1.door);
    System.out.println(
        "c2 의 color = " + car2.color + ", gearType = " + car2.gearType + ", door = " + car2.door);


  }

}
