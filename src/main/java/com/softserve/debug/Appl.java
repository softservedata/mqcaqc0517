package com.softserve.debug;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Appl {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		System.out.print("num=");
		try {
			num = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("I/O Error.");
		}
		Calc2 calc = new Calc2(num);
		//System.out.print("\nCount Digits=" + calc.countNonZeroDigits());
		System.out.print("\nSum Digits=" + calc.sumDigits());
		System.out.print("\nCount Digits=" + calc.countNonZeroDigits());
	}
	
}
