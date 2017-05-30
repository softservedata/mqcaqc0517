//package com.softserve.edu.projectname.test;
package com.softserve.edu;

/**
 * Package includes classes
 * 
 * @author John Smit
 * @version 1.0 12/05/17
 */
public class Example {
	private int i = 11;

	/**
	 * <b>Super Method</b>
	 * @param k - type int
	 *
	 */
	public void m1(int k) {
		int j = 1;
		System.out.println("i=" + i + "   j = " + j + k);
	}

	public static void main(String[] args) {
		System.out.println("My first program");
		//
		Example e1 = new Example();
		Example e2 = new Example();
		e1.i = 111;
		e2.i = 112;
		System.out.println("i=" + e1.i);
		System.out.println("i=" + e2.i);
		e1.m1(1);
		//
		for (String arg : args) {
			System.out.println("Command line arg: " + arg);
		}

	}

}
