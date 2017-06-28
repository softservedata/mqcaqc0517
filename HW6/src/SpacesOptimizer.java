package lesson6;

public class SpacesOptimizer {
	String inpStr;
	String modStr;

	public String getSymbol(String s){
		inpStr = s;
		
		modStr = s.replaceAll("[ ]+", " ");				
		
		return modStr;
	}
}
