package HWpackage;

public class Appl {

	public static void main(String[] args) {

		Figures r1 = new Rectangle(5, 2);
		Figures r2 = new Rectangle(0.7, 8.5);
		Figures sq1 = new Square(8);

		Figures[] elements = { r1, r2, sq1 };
		for (int i = 0; i < elements.length; i++) {
			elements[i].square();
			System.out.println(
					"Class name: " + elements[i].getClass() + " Area " + (i + 1) + " = " + elements[i].square());
		}

	}

}