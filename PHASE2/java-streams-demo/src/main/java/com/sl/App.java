package com.sl;

import java.util.List;
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
		

	}
}
