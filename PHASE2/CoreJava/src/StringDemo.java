
public class StringDemo {

	public static void main(String[] args) {
		// Immutabilty demo

		String s = "Hello";

		System.out.println(s); // Hello

		System.out.println(s.toUpperCase());

		System.out.println(s); // Hello

		// Equality Demo
		System.out.println("\n\nEquality Demo");
		String s1 = "John";
		String s2 = "JOHN";
		String s3 = "Mathew";
		System.out.println("Compare String s1.equals(s2):		 " + s1.equals(s2)); // false
		System.out.println("Compare String s1.equals(s3):		 " + s1.equals(s3)); // false
		System.out.println("Compare String s1.equalsIgnoreCase(s2):		 " + s1.equalsIgnoreCase(s2)); // true
		System.out.println("Compare String s1.equalsIgnoreCase(s3):		 " + s1.equalsIgnoreCase(s3)); // false
		
		
		
		// Other methods
		System.out.println("\n\nOther methds Demo");
		String s11="Java is programming language";
		System.out.println("s1.startsWith(\"Java\")" + s11.startsWith("Java")); // true
		System.out.println(s11.endsWith("language")); // true
		System.out.println(s11.substring(10)); // 10 is	starting index to end 
		System.out.println(s11.indexOf("programming")); // 
		System.out.println(s11.trim());
		
		
		// Split a string into an array.
		System.out.println("\n\n Split a string into an array.");
		String s111="abc@test.com";
		String[] s111Array=s111.split("@"); // divide string		based on @
		for(String c:s111Array) // foreach loop
		{
		System.out.println(c);
		}
		
		// Replacement
		System.out.println("\n\n Replacement demo");
		String str1="Heello";
		String str1Replaced=str1.replace('e', 'k');
		System.out.println(str1); //Hello 
		System.out.println(str1Replaced); // Hkllo


	}

}
