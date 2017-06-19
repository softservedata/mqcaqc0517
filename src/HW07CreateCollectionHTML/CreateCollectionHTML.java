package HW07CreateCollectionHTML;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateCollectionHTML 
{
	public static void main(String args[]) 
	{
		// String pattern = "<[^>]+>";
		// String pattern = "<(\\w+)>[^<]*</\\1>";
		
		String pattern = "<([p])>[^<>]*</\\1>";
		String text = "<p>   Beginning </p> <b>Beginning with bold text</b> next, text <div> body,</div><i>italic text</i> end of text.</p> <p> Hokey and shayba )))) </p> <p>    %$*^(&)*_)))jlkjp\\\\     </p>";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);

		if (m.matches()) 
		{
			System.out.println("\tAll text corespond pattern");
		} else 
		{
			System.out.println("\tText NOT corespond pattern");
		}
		m.reset();
		List<String> result = new ArrayList<>();

		while (m.find()) 
			{
				System.out.println(text.substring(m.start(), m.end()));
				result.add(text.substring(m.start() + 3, m.end() - 4).trim());
			}
		System.out.println("result = " + result);
	}
}
