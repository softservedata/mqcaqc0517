package HWpackage;

import java.util.Arrays;

public class ComparingArrays {

	public static void main(String[] args) {
		int[] array1 = { 6, 4, 2 };
		int[] array2 = { 2, 4, 6 };

		Arrays.sort(array1);
		Arrays.sort(array2);

		if (array1.length != array2.length) {
			System.out.println("not equil");
		}

		boolean result = Arrays.equals(array1, array2);

		System.out.println("Arrays are equil: " + result);

	}

}