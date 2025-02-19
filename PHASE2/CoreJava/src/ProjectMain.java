public class ProjectMain {
	public static void main(String[] args) {
		B b1 = new B();

		System.out.println("b1.x =  " + b1.x);

		b1.x = 100;

		System.out.println("b1.x =  " + b1.x);

		b1.method1(); // prints value of x in b1

		int result1 = b1.method2(2, 3);
		System.out.println("result1 =  " + result1);
		
		int result2 = b1.method2(2, 3.5f);
		System.out.println("result2 =  " + result2);
		
		float result3 = b1.method2(2.5f, 3.5f);
		System.out.println("result3 =  " + result3);
		
		
		String s = "Hello Wortld";
		boolean result4 = s.contains("Hello");
		System.out.println("\n result4 =  " + result4);
		
		System.out.println("\n static method demo (method5 of B)   ");
		B.method5();
		
	}
}
