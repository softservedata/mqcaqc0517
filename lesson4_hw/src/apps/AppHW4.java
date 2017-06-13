package apps;

import shapes.Figure;
import shapes.Rectangle;
import shapes.Square;

public class AppHW4 {
	public static void main(String[] args) {
		Figure shapes[] = new Figure[3];
		shapes[0] = new Rectangle(200, 8);
		shapes[1] = new Rectangle(10, 45);
		shapes[2] = new Square(25);
		
		for(int i=0; i < shapes.length; i++) {
			System.out.println("Area of " + shapes[i].name() + " is: " + shapes[i].area());
		}
	}

}
