package com.softserve.edu;

public class B extends A {

	//private void m1() {
	public void m1() {
		System.out.println("Class B, m1()");
		super.m1();
	}
	
	public void work() {
		m1();
	}
	
}
