package com.softserve.training;

public class Appl {
	public static void main(String[] args) {
		String text = "Hello World";
		Box box = new Box();
		box.set(text);
		//
		// Other code
		//
		Integer i = (Integer) box.get();
		System.out.println(i);
	}
}
