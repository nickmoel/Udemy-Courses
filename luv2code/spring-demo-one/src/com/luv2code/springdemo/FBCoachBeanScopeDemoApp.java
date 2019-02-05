package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//Practice Activity #3 - Bean Scopes with XML Configuration
//1. Add bean scopes to your new Coach implementation that you created in one of the previous activities.
//
//2. Test singleton scope and prototype scope as I did in the videos.
//
//3. Verify that the bean scopes are being applied as desired.
public class FBCoachBeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("FBCbeanScope-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are the same bean
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);
		
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");

		// close the context
		context.close();

	}

}
