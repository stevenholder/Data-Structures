
public class PalyndromeChecker {
	
	public static boolean isPalyndrome(String string) {
		OurStack<String> stack = new OurArrayStack<String>();
		
		String[] array = new String[string.length()]; 
		array = string.split("|");
		
		for(String s : array)
			stack.push(s);
		
		StringBuilder reversedString = new StringBuilder();
		
		while(!stack.empty())
			reversedString.append(stack.pop());
			
		return string.equalsIgnoreCase(reversedString.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(isPalyndrome("radar"));
	}
}
