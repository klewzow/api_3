package com.gmail.klewzow;

import java.io.File;
 
import java.util.List;
 
 
public class Main {

	public static void main(String[] args) {
		File file = new File("xml.txt");
		ReadFiles rf = new ReadFiles(file);
 
		List<String> listString = rf.reader();
 
		listString.stream().forEach(System.out::println);
  
	}

}
