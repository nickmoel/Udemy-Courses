package com.luv2code.practice6;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component

public class FileFortuneService implements FortuneService {
	File file = new File("C:/users/Nick/Luv2CodeFortunes.txt");

	Random myRandom = new Random();
	List<String> data = new ArrayList<String>();

	public FileFortuneService() {

		System.out.println("Reading fortunes from file: " + file);
		System.out.println("File exists: " + file.exists());

		int i = 0;
		Scanner scanner = null;

		// String[] data = new String[2];

		try {
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				data.add(scanner.nextLine());
			}

			String[] arr = data.toArray(new String[0]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	@Override
	@PostConstruct
	public String getFortune() {
		System.out.println(">> LifeCoach: inside init");
		// pick a random string from the array
		int index = myRandom.nextInt(data.size());

		String tempFortune = data.get(index);
		// System.out.println("Fortune being retrieved from file: " + tempFortune);
		if (tempFortune == null) {
			System.out.println("Do stuff");
		}
		return tempFortune;
	}

}
// Random random = new Random();
// System.out.println("Reading fortunes from file: " + file);
// System.out.println("File exists: " + file.exists());
// try {

// Scanner scanner = new Scanner(file);
// while (scanner.hasNextLine()) {

// String[] fortuneArray = { scanner.nextLine() };

// int index = random.nextInt(fortuneArray.length);

// String fortune = fortuneArray[index];

// return fortune;

// }

// }

// catch (FileNotFoundException e) {

// e.printStackTrace();

// }

// return null;

// }

//}
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class FileFortuneService implements FortuneService {
//
//	private String fileName = "C:/users/Nick/Luv2CodeFortunes.txt";
//	private List<String> theFortunes;
//
//	// create a random number generator
//	private Random myRandom = new Random();
//	 
//	public FileFortuneService() {
//
//		File theFile = new File(fileName);
//		
//		System.out.println("Reading fortunes from file: " + theFile);
//		System.out.println("File exists: " + theFile.exists());
//		
//		// initialize array list
//		theFortunes = new ArrayList<String>();
//		
//		// read fortunes from file
//		try (BufferedReader br = new BufferedReader(
//				new FileReader(theFile))) {
//
//			String tempLine;
//
//			while ((tempLine = br.readLine()) != null) {
//				theFortunes.add(tempLine);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	@PostConstruct
//	public String getFortune() {
//		// pick a random string from the array
//		int index = myRandom.nextInt(theFortunes.size());
//
//		String tempFortune = theFortunes.get(index);
//
//		return tempFortune;
//	}
//
//}

//@Component
//public class FileFortuneService implements FortuneService {
//
//	private String fileName = "C:/foobar/fortune-data.txt";
//	private List<String> theFortunes;
//
//	// create a random number generator
//	private Random myRandom = new Random();
//
//	public FileFortuneService() {
//
//		File theFile = new File(fileName);
//		
//		System.out.println("Reading fortunes from file: " + theFile);
//		System.out.println("File exists: " + theFile.exists());
//		
//		// initialize array list
//		theFortunes = new ArrayList<String>();
//		
//		// read fortunes from file
//		try (BufferedReader br = new BufferedReader(
//				new FileReader(theFile))) {
//
//			String tempLine;
//
//			while ((tempLine = br.readLine()) != null) {
//				theFortunes.add(tempLine);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public String getFortune() {
//		// pick a random string from the array
//		int index = myRandom.nextInt(theFortunes.size());
//
//		String tempFortune = theFortunes.get(index);
//
//		return tempFortune;
//	}
//
//}
//
