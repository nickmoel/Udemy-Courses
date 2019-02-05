package com.luv2code.practice6;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public String getDailyWorkout() {
		return "Don't Think about changing your life later, START NOW ";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
