package apps;

import shapes.Figure;
import shapes.Rectangle;
import shapes.Square;

public class App {
	public static void main(String[] args) {
		Figure shapes[] = new Figure[2];
		shapes[0] = new Rectangle(200, 8);
		shapes[1] = new Square(25);
		
		for(int i=0; i < shapes.length; i++) {
			System.out.println("Area of " + shapes[i].name() + " is: " + shapes[i].area());
		}
	}

}
