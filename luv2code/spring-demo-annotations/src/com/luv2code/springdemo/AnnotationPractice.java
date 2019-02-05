package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.Coach;

public class AnnotationPractice {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("practiceApplicationContext.xml");

		// get bean from spring container
		// Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		// no longer using custom bean name
		Coach theCoach = context.getBean("lifeCoach", Coach.class);

		// call a method on the bean
		System.out.print(theCoach.getDailyWorkout());
		// call our methods to get the literal values
		System.out.print(theCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
