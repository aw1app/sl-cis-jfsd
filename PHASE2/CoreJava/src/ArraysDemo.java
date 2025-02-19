
public class ArraysDemo {

	public static void main(String[] args) {
		
		
		int[][] numbers = { 
				{ 1, 2, 3, 4, 5 },
				{ 6, 7, 8, 9, 0 }
				};
		
		
		System.out.println(numbers[1][3] + "\t"); // 9
		
		
		System.out.print("\n Looping 2d array \n");
		for (int i = 0; i < numbers.length; i++) {
			
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + "\t");
			};
			
			System.out.println("");
		}

	}

}
