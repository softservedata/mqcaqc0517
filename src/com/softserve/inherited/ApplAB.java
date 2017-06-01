package com.softserve.inherited;

public class ApplAB {
	
	/**
	 * 
	 * @param args from command line.
	 */
	public static void main(String[] args) {
		System.out.println("The Start.");
		//
//		ClassA a;
//		a = new ClassA();
//		System.out.println("Test ClassA.");
//		a.m1();
//		a.m2();
//		a.m3();
//		a.m4();
		//
		ClassA b;
		b = new ClassB();
		System.out.println("Test ClassB.");
		b.m1();
		b.m2();
		b.m3();
		b.m4();
		((ClassB)b).m5();
		//
//		ClassB b0;
//		b0 = new ClassB();
//		System.out.println("Test_0 ClassB.");
//		b0.m1();
//		b0.m2();
//		b0.m3();
//		b0.m4();
//		b0.m5();
		//
		System.out.println("The End.");
	}
}
