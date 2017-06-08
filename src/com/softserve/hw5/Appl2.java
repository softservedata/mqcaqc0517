package com.softserve.hw5;

public class Appl2 {

	public static void main(String[] args) {
		//int[] a1 = { 3, 2, 4, 1, 1 };
		//int[] a2 = { 1, 3, 2, 4, 4 };
		//
		//ArrayWrapper aw1 = new ArrayWrapper(a1);
		//ArrayWrapper aw2 = new ArrayWrapper(a2);
		//
		System.out.println("Input Array1:");
		ArrayWrapper aw1 = new ArrayWrapper();
		System.out.println("\nInput Array2:");
		ArrayWrapper aw2 = new ArrayWrapper();
		//
		System.out.println("Origin Arrays:");
		System.out.println("Array1:");
		aw1.print();
		System.out.println("\nArray2:");
		aw2.print();
		//
		System.out.println("\ncompare: " + CompareArray.compare(aw1, aw2));
		System.out.println("compareSort: " + CompareArray.compareSort(aw1, aw2));
	}

}
