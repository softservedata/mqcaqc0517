package com.softserve.hw5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayWrapper {

	private int[] array;

	public ArrayWrapper() {
		read();
	}

	public ArrayWrapper(int[] array) {
		// this.array = array;
		//
		init(array);
	}

	private void init(int[] array) {
		this.array = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
	}

	private void read() {
		int n = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("n=");
		try {
			n = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error. e=" + e.toString());
			System.exit(1);
		}
		if (n < 1) {
			System.out.println("Error, n = " + n);
			System.exit(1);
			//throw new RuntimeException("Error, n = " + n);
		}
		array = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("array[" + i + "] = ");
			try {
				array[i] = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
			} catch (Exception e) { // NumberFormatException
				System.out.println("I/O Error. e=" + e.toString());
				System.exit(1);
			}
		}
	}

	public int[] getArray() {
		return array;
	}

	public int length() {
		return array.length;
	}

	public int getAt(int i) {
		return array[i];
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}

}
