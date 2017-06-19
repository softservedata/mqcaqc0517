package HW06DeleteSpace;

public class DeleteAdditionSpace 
{
	public static void main(String[] args) 
	{
		String strOld = "My  first     %)*(&#__@$%          example     !";
		String search = "  ";
		String sub =" ";
		String result = "";
		int i;
		System.out.println("Old string is : " + strOld);
		
		// Change all double spaces to single spaces. This iterative process. 
		do { 
			// This next printLn need to track all changes in the cycle
			// System.out.println("New string is : " + strOld);
			// Explanation. Method indexOf() - search for the first occurrence of symbol or substring. 
			i = strOld.indexOf(search);
				if (i != -1) 
				{
					result = strOld.substring(0, i);
					// Explanation. Method substring(int firstIndex, int secondIndex). 
					result = result + sub;
					result = result + strOld.substring(i + search.length());
					strOld = result;
				}
			}
		while (i != -1);
		System.out.println("New string is : " + strOld);
	}
}
