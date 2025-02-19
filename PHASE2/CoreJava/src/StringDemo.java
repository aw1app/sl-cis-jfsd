
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

	}

}
