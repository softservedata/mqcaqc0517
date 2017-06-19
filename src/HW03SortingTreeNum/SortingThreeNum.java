package HW03SortingTreeNum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortingThreeNum 
{
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = 0, num2 = 0, num3 = 0; // ???

		try 
		{
			System.out.print("Input num1 = ");
			num1 = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
			System.out.print("Input num2 = ");
			num2 = Integer.parseInt(br.readLine());
			System.out.print("Input num3 = ");
			num3 = Integer.parseInt(br.readLine());
		} catch (Exception e) { // NumberFormatException
			
	System.out.println("I/O Error. e = " + e.toString()); // System.exit(1);
	}
	
	int[] array = { num1, num2, num3 };
	Arrays.sort(array);

	System.out.println("Print sorting array - " + Arrays.toString(array));
	}
}
