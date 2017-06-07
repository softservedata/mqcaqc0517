package HWpackage;

import java.util.Arrays;

public class ComparingArrays {

	public static void main(String[] args) {
		int[] array1 = { 2, 4, 0, 8, 6 };
		int[] array2 = { 2, 4, 6 };

		boolean result = Arrays.equals(array1, array2);

		System.out.println("Arrays are equil: " + result);

	}

}