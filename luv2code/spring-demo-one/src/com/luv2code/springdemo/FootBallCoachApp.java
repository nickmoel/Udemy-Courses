package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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

public class FootBallCoachApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("FBCoachApplicationContext.xml");
		// retrieve bean from spring container
		FootBallCoach theCoach = context.getBean("myFootBallCoach", FootBallCoach.class);

		// call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		// call our methods to get the literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());

		// close the context
		context.close();
	}

}
