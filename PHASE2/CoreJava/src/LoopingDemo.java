
public class LoopingDemo {

	public static void main(String[] args) {

		// Demo if else
				System.out.println("\n Demo for");

		for (int i = 1; i <= 10; i++) {
			System.out.println(i * i);
		}
		
		
		// Demo while
		System.out.println("\n Demo while");

		int j = 1;
		
		while ( j <= 10 ) {
			System.out.println(j * j);
			
			j++;
		}
		
		// Demo do while
				System.out.println("\n Demo do while");

				int k = 1;
				
				do {
					System.out.println(k * k);
					
					k++;
				}while ( k <= 10 );

	}

}
