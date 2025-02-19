
// Demo classes and methods
public class B {
	// variables
	int x;

	// Methods
	void method1() {
		System.out.println(x);
	}

	/*
	 * This method takes two integers and returns the sume of those integers
	 */
	int method2(int arg1, int arg2) { // signature is int,int
		int c = arg1 + arg2;

		return c;
	}

	// Overloaded method
	int method2(int arg1, float arg2) {// signature is int,float
		int c = arg1 + (int) arg2;
		return c * 10;
	}

	// Overloaded method
	float  method2(float arg1, float arg2) {// signature is float,float
		float c = arg1 +  arg2;
		return c * 100;
	}

}
