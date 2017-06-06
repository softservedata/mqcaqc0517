package com.softserve.edu;

public class Appl {

	public static void main(String[] args) {
		System.out.println("Appl");
		A b = new B();
		b.m1();
		((B)b).work();
		//
		A a = new A(10);
		a.m1();
	}
}
