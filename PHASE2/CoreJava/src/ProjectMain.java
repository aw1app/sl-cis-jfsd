public class ProjectMain {
	public static void main(String[] args) {
		B b1 = new B();

		System.out.println("b1.x =  " + b1.x);

		b1.x = 100;

		System.out.println("b1.x =  " + b1.x);

		b1.method1(); // prints value of x in b1

		int result1 = b1.method2(2, 3);
		System.out.println("result1 =  " + result1);
	}
}
