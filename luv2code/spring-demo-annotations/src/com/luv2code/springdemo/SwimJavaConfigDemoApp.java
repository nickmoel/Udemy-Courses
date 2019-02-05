package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read java config file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);

		// get bean from spring container
		// Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		// no longer using custom bean name
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call the methods to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		
		// call our new swim coach methods .. has the property values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());

		// close the context
		context.close();
	}

}
