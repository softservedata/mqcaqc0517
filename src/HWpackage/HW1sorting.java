package HWpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HW1sorting {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 0, y = 0, z = 0; // ???
		try {
			System.out.print("x=");
			x = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
			System.out.print("y=");
			y = Integer.parseInt(br.readLine());
			System.out.print("z=");
			z = Integer.parseInt(br.readLine());
		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error. e = " + e.toString());
			// System.exit(1);
		}
		int[] array = { x, y, z };
		Arrays.sort(array);

		System.out.println(Arrays.toString(array));

	}
}
