package com.luv2code.springdemo;

import java.util.Random;

//Practice Activity #2 - Dependency Injection with XML Configuration

//1. Define a new implementation for the FortuneService.
//
//a. When the getFortune() method is called it should return a random fortune from the array.
//
//b. Your fortune service should define three fortunes in an array. 
//
//2. Inject your new dependency into your Coach implementation.
//
//3. Test your application to verify you are retrieving random fortunes.


public class RandomFortuneService implements FortuneService {
	String[] myFortunes = { "today is your Lucky day!", "Bad news bears!", "just another day!" };
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(myFortunes.length);

		String theFortune = myFortunes[index];
		System.out.println(index);
		return theFortune;
	}

}