package com.luv2code.practice5;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach {
//	@Qualifier("fileFortuneService")
	@Autowired
	private FortuneService fortuneService;

	// define a default constructor
	public LifeCoach() {
		System.out.println(">> LifeCoach: inside default constructor");
	}

	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}

	@Override
	public String getDailyWorkout() {
		return "Don't Think about changing your life later, START NOW ";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
