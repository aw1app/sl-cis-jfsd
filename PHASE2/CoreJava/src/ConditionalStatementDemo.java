
public class ConditionalStatementDemo {

	public static void main(String[] args) {

		int x = 14;
		int y = 12;

		// Demo if
		System.out.println("\n Demo if ");
		if (x < y) {
			System.out.println("x is less		than y");
		}
		;

		// Demo if else
		System.out.println("\n Demo if else");
		if (x < y) {
			System.out.println("x is less	than y");
		} else {
			System.out.println("x is greater	than y");
		}

		// Demo if else
		System.out.println("\n Demo  nested if else");
		int age = 25;
		int weight = 48;
		if (age >= 18) {
			if (weight > 50) {
				System.out.println("You are 		eligible for Boxing championship");

			} else {
				System.out.println("You are not 		eligible for Boxing Championship");

			}
		} else {
			System.out.println("Age must be 		greater than 18");
		}

		// Demo if else
		System.out.println("\n Demo switch");

		int number = 200;
		switch (number) {
		// Case statements
		case 100:
			System.out.println("100");
			break;
		case 200:
			System.out.println("200");
			break;
		case 300:
			System.out.println("300");
			break;
		// Default case statement
		default:
			System.out.println("Not in		100, 200 or 300");
		}

	}

}
