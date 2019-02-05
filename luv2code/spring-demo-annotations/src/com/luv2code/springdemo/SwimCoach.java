package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
// java code  spring config
	private FortuneService fortuneService;
	@Value("${foo.email}")// field level injection from sport.properties
	private String email;
	@Value("${foo.team}")// field level injection from sport.properties
	private String team;

	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	

}
