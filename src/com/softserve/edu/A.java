package com.softserve.edu;

public class A {
	private int i;

	public A(int i) {
		this.i = i;
	}

	public A() {
		this.i = 0;
	}

	public int getI() {
		return i;
	}

	// public void setI(int i) {
	// this.i = i;
	// }

	public void m1() {
		System.out.println("Class A, m1(), i = " + i);
	}

}
