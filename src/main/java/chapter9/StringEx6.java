package chapter9;

public class StringEx6 {
  public static void main(String[] args) {
    int iVal = 100;
    String strVal = String.valueOf(iVal);

    double dVal = 200.0;
    String strVal2 = String.valueOf(dVal);

    double sum = Integer.parseInt("+" + strVal) + Double.parseDouble(strVal2);
    double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);


  }

}
