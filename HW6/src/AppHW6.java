package lesson6;
/* Homework:
*  Написати код для заміни у заданій стрічці послідовності кількох пробілів на один.
*/

import java.util.Scanner;

public class AppHW6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String usrStr = "";
		
		try {
			System.out.print("Enter string: ");
			usrStr = sc.nextLine();
		}
		catch (Exception exc) {
			System.out.println("I/O Error: " + exc.toString());			
		}
		
		SpacesOptimizer pOb = new SpacesOptimizer();
		pOb.getSymbol(usrStr);
		
		System.out.println("Modified string: " + pOb.modStr);
	}

}

