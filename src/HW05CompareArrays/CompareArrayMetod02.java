package HW05CompareArrays;
import java.util.Arrays;
public class CompareArrayMetod02 
{
	public static void main(String[] args) 
	{
		String d = "1"; 
		String [] array1 = { "6", "4", "1", d };
		String [] array2 = { "6", "4", "1", "1" };

		boolean result = Arrays.equals(array1, array2);
		System.out.println("Arrays are equil: " + result);
	}
}