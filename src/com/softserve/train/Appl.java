package com.softserve.train;

public class Appl {

	public double getRectangleArea(double a, double b) {
		return a * b;
	}

	// Overload
	public void work(int i) {
		i = i + 1;
		System.out.println("work(int i), i = " + i);
		// return i;
	}

	// Overload
	public void work(String s) {
		s = s + " work added";
		System.out.println("work(String s), s = " + s);
	}

	// Overload
	public void work(StringBuilder s) {
		s.append(" work added");
		System.out.println("work(StringBuilder s), s = " + s);
	}

	public static void main(String[] args) {
		Appl appl = new Appl();
		double data = appl.getRectangleArea(2, 3);
		System.out.println("Data = " + data);
		//
//		int i = 1;
//		appl.work(i);
//		System.out.println("i = " + i);
		//
//		StringBuilder sb = new StringBuilder("123");
//		appl.work(sb);
//		System.out.println("sb = " + sb);
		//
		String s = "123"; // String s = new String("123"); 
		appl.work(s);
		System.out.println("s = " + s);
	}

}
