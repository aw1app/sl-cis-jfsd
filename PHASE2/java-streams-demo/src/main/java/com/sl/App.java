package com.sl;

import java.util.List;
import java.util.stream.Stream;

public class App {
	public static void main(String[] args) {
		System.out.println("Java Streams Demo");

		// Creating Stream from values
		Stream<String> langStream = Stream.of("Java", "Python", "C++", "JavaScript", "C#", "Rust");

		System.out.println(" No of elements in stream  langStream = " + langStream.count());
		
		
		List<String> langList = List.of("Java", "Python", "C++", "JavaScript", "C#", "Rust");
		

		// Filtering
		List<String> langListStartingWithJ = langList
				.stream()
				.filter(elem -> elem.startsWith("J"))
				.toList();
		
		System.out.println(" No of elements in collection  langListStartingWithJ = " + langListStartingWithJ.size());
		
		
		// Limiting 
		List<String> langSListLimitedTo2Elements = langList
				.stream()
				.limit(3)
				.toList();
		
		System.out.println(" No of elements in collection  langStreamLimitedTo2Elements = " + langSListLimitedTo2Elements.size());
		System.out.println("langStreamLimitedTo2Elements Elements are " +langSListLimitedTo2Elements );
		

	}
}
