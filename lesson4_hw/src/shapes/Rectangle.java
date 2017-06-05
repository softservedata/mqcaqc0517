package shapes;

public class Rectangle implements Figure {
	double width;
	double height;
	public String name;
	
	public Rectangle() {
		width = 0;
		height = 0;
		name = "";
	}
	
	public Rectangle(double x, double y) {
		this.height = x;
		this.width = y;
		name = "rectangle";
	}
	
	public double area() {
		return width * height;
	}
	
	public String name() {
		return name;
	}

}
