/*
 * Homework:
Нехай задана стрічка з фрагментом html коду, яка містить кілька тегів <p>text</p>.
Сформувати колекцію лише із вмістимого параграфів. Вмістиме інших тегів ігнорувати.
Вивести колекцію на консоль. */

import java.util.ArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppHW7 {

	public static void main(String[] args) {
				
		String text = "<!DOCTYPE html> <html> <head> <title>Page Title</title>"+
		"</head> <body> <h1>This is a Heading</h1> " +
		"<p>This is a paragraph 1.</p>" +
		"<p>This is a paragraph 2.</p>" +
		"</body> </html>";
		
		String pattern = "(p>[^<]+<)";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);

		m.reset();
		//
		List<String> result = new ArrayList<>();
		while (m.find()) {
			//System.out.println(text.substring(m.start(), m.end()));
			result.add(text.substring(m.start()+2, m.end()-1).trim());
		}
		//System.out.println("\nresult = " + result);
		for(String i:result)
			System.out.println(i);
	}

}
