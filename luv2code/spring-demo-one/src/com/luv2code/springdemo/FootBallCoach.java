package com.luv2code.springdemo;

// Practice Activity Class 
public class FootBallCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;

	public FootBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public FootBallCoach() {
		System.out.println("FootBallCoach:inside no-arg constructor");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Hit the tackling dummy for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("FootBallCoach:inside inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("FootballCoach:inside inside setter method - setEmailaddress");

		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("footBallCoach:inside inside setter method - setTeam");

		this.team = team;
	}

}
