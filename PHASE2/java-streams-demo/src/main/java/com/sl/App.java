package com.sl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
	public static void main(String[] args) {
		System.out.println("Java Streams Demo");

		// Creating Stream from values
		Stream<String> langStream = Stream.of("Java", "Python", "C++", "JavaScript", "C#", "Rust", "C");

		System.out.println(" No of elements in stream  langStream = " + langStream.count());
		
		
		// Creating Streams from Collections like list, set
		System.out.println("\n Creating Streams from Collections like List, Set  demo ");
		List<String> langList = List.of("Java", "Python", "C++", "JavaScript", "C#", "Rust", "C");
		System.out.println("langList elements  are " + langList);
		

		// Filtering
		System.out.println("\n Filtering  only  demo ");
		List<String> langListStartingWithJ = langList
				.stream()
				.filter(elem -> elem.startsWith("J"))
				.toList();
		
		System.out.println(" No of elements in collection  langListStartingWithJ = " + langListStartingWithJ.size());
		
		
		// Limiting 
		System.out.println("\n Limiting only demo ");
		List<String> langSListLimitedTo3Elements = langList
				.stream()
				.limit(3)
				.toList();
		
		System.out.println(" No of elements in collection  langStreamLimitedTo2Elements = " + langSListLimitedTo3Elements.size());
		System.out.println("langStreamLimitedTo2Elements Elements are " +langSListLimitedTo3Elements );
		
		//Filtering and Limiting
		System.out.println("\n Filtering and Limiting demo ");
		List<String> langListFilteredAndLimited = langList.stream()
		.filter(elem -> elem.startsWith("C"))  /* 3 elements "C++" "C#"  "C" */
		.limit(2)   /* 2 elements "C++" "C#"  */
		.toList();
		System.out.println("langListFilteredAndLimited Elements are " + langListFilteredAndLimited );
		
		// same by collectors
		System.out.println("\n Filtering and Limiting using .collect(Collectors.toList()) demo ");
		List<String> langListFilteredAndLimited1 = langList.stream()
		.filter(elem -> elem.startsWith("C"))  /* 3 elements "C++" "C#"  "C" */
		.limit(2)   /* 2 elements "C++" "C#"  */
		.collect(Collectors.toList());
		System.out.println("langListFilteredAndLimited1 Elements are " + langListFilteredAndLimited1 );
		
		
		//Mapping 
		System.out.println("\n Mapping elements to thier uppercase demo ");
		List<String> langListMapped = langList.stream()
		.map( elem -> elem.toUpperCase()) /* all elements are now in caps [JAVA, PYTHON, C++, JAVASCRIPT, C#, RUST, C] */
		.collect(Collectors.toList());
		System.out.println("langListMapped Elements are " + langListMapped );
		
		// Convert List to Set (removes duplicates)
		System.out.println("\n Convert List to Set (removes duplicates) demo ");
		List<String> names = Arrays.asList("Apple", "Banana", "Apple", "Orange");
		
        Set<String> uniqueNames = names.stream()
                .collect(Collectors.toSet());
        System.out.println("names " + names );
        System.out.println("uniqueNames " + uniqueNames );
        
        
        //Stream with Primitive Types
        System.out.println("\n\n Stream with Primitive Types demo ");
        IntStream.range(1, 6) /* create a stream of numbers 1,2,3,4,5 */
        .forEach(System.out::print); /* 12345 */
        
		// reduction function
        System.out.println("\n\n reduction function demo ");
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        // Sum all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum); // Output: Sum: 100
        
        int max =numbers.stream()
        .max(Integer::compareTo)
        .get();
        System.out.println("Max: " + max); // Output: Sum: 40
        
        
       

	}
}
