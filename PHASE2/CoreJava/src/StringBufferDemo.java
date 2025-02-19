
public class StringBufferDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuffer sb = new StringBuffer("Hi ");
		System.out.println(sb);

		StringBuffer sb1 = sb.append("Java ").append(" is").append(" powerful").append(" programming")
				.append(" language ");

		System.out.println(sb);

		if (sb == sb1) {
			System.out.println("True");
		} else {
			System.out.println("false");
		}
		
		// Insert demo
		StringBuffer sb11 = new StringBuffer("let");
		sb11.insert(2, "n");
		System.out.println("After insert -- " +		sb11.toString());
		
		
		// Challenge: Given a text , check where it is palindrome
	}

}
