package shapes;

public class Square implements Figure {
	double width;
	double height;
	public String name;
	
	public Square() {
		height = width = 0;
		name = "";
	}
	
	public Square(double x) {
		this.height = this.width = x;
		name = "square";
	}
	
	public double area() {
		if((width == 0) | (height == 0)) {
			return 0;
		}
		
		return width * height;
	}
	
	public String name() {
		return name;
	}

}