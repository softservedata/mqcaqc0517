package HWpackage;

public class Square implements Figures{
	private double a;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public Square(double a) {
		super();
		this.a = a;
	}

	public double square(){
		return a*a;
	}
	
	


}
