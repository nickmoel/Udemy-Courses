package com.luv2code.practice7;

import org.springframework.beans.factory.annotation.Value;

public class PitchingCoach implements Coach {
// java code  spring config
	private FortuneService fortuneService;
	@Value("${foo.email}")// field level injection from sport.properties
	private String email;
	@Value("${foo.team}")// field level injection from sport.properties
	private String team;

	public PitchingCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Thorw 10 curves and 10 sliders as a warm up.";
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
