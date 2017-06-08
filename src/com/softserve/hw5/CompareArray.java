package com.softserve.hw5;

import java.util.Arrays;

public class CompareArray {

	public static boolean compare(ArrayWrapper arr0, ArrayWrapper arr1) {
		boolean result = arr0.length() == arr1.length();
		//
		if (result) {
			for (int i = 0; i < arr0.length(); i++) {
				boolean found = false;
				for (int j = 0; j < arr1.length(); j++) {
					if (arr0.getAt(i) == arr1.getAt(j)) {
						found = true;
						break;
					}
				}
				if (!found) {
					System.out.println("not equal");
					System.exit(0);
				}
			}
		}
		return result;
	}
	public static boolean compareSort(ArrayWrapper arr0, ArrayWrapper arr1) {
		boolean result = arr0.length() == arr1.length();
		//
		if (result) {
			ArrayWrapper a0 = new ArrayWrapper(arr0.getArray());
			ArrayWrapper a1 = new ArrayWrapper(arr1.getArray());
			//
			Arrays.sort(a0.getArray());
			Arrays.sort(a1.getArray());
			for (int i = 0; i < a0.length(); i++) {
				if (a0.getAt(i) != a1.getAt(i)) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}
