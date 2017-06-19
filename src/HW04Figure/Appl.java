package HW04Figure;

public class Appl {

 public static void main(String[] args) {

  Rectangle r1 = new Rectangle(5, 4);
  Rectangle r2 = new Rectangle(0.8, 8.5);
  Square sq1 = new Square(5);

  Figures[] elements = { r1, r2, sq1 };
  for (int i = 0; i < elements.length; i++) {
   elements[i].square();
   System.out.println(
     "Class name: " + elements[i].getClass() + " Area " + (i + 1) + " = " + elements[i].square());
  }
 }
}