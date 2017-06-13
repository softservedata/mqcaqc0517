package HWpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Whitespaces {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter text with odd whitespaces");
			
			String str = br.readLine();
			System.out.println("text without odd whitespaces");
			System.out.println(str.trim().replaceAll("\\s{2,}", " "));

		} catch (Exception e) {
			System.out.println("I/O Error. e = " + e.toString());

		}
	}

}
