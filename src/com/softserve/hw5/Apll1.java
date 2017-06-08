package com.softserve.hw5;

public class Apll1 {

	public static void main(String[] args) {
		int[] a1 = { 3, 2, 4, 1, 1 };
		int[] a2 = { 1, 3, 2, 4, 4 };
		//
		if (a1.length != a2.length) {
			System.out.println("not equal");
			System.exit(0);
		}
		//
		for (int i = 0; i < a1.length; i++) {
			boolean found = false;
			for (int j = 0; j < a2.length; j++) {
				if (a1[i] == a2[j]) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("not equal");
				System.exit(0);
			}
		}
		//
		System.out.println("yes equal");
	}

}
