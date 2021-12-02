package chapter7;

public class RepairableTest {

  public static void main(String[] args) {
    Tank tank = new Tank();
    Dropship dropship = new Dropship();
    Marin marin = new Marin();

    SCV scv = new SCV();

    scv.repair(tank);
    scv.repair(dropship);
//    scv.repair(marin);

    System.out.println("result");
  }
}

interface Repairable {

}

class Unit3 {

  int hitPoint;
  final int MAX_HP;

  public Unit3(int MAX_HP) {
    this.MAX_HP = MAX_HP;
  }
}

class GroundUnit extends Unit3 {

  GroundUnit(int hp) {
    super(hp);
  }
}

class AirUnit extends Unit3 {

  AirUnit(int hp) {
    super(hp);
  }
}

class Tank extends GroundUnit implements Repairable {

  public Tank() {
    super(150);
    hitPoint = MAX_HP;
  }

  public String toString() {
    return "Tank";
  }
}

class Dropship extends AirUnit implements Repairable {

  public Dropship() {
    super(125);
    hitPoint = MAX_HP;
  }

  public String toString() {
    return "Dropship";
  }
}

class Marin extends GroundUnit {

  public Marin() {
    super(40);
    hitPoint = MAX_HP;
  }

  public String toString() {
    return "Marin";
  }
}

class SCV extends GroundUnit implements Repairable {

  public SCV() {
    super(60);
    hitPoint = MAX_HP;
  }

  void repair(Repairable repairable) {
    if (repairable instanceof Unit3) {
      Unit3 unit3 = (Unit3) repairable;

      while (unit3.hitPoint < unit3.MAX_HP) {
        unit3.hitPoint++;
      }

      System.out.println(unit3.toString() + " 의 수리가 끝났습니다. ");
    }
  }
}



