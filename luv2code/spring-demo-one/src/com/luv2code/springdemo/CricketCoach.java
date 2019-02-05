package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	//private RandomFortuneService randomFortuneService;

	private String emailAddress;
	private String team;

	public CricketCoach() {
		System.out.println("CricketCoach:inside no-arg constructor");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub

		return fortuneService.getFortune();
//return randomFortuneService.getFortune();
	}

//	public void setFortuneService(RandomFortuneService randomFortuneService) {
//		System.out.println("CricketCoach:inside inside setter method - setFortuneService");
//		this.randomFortuneService = randomFortuneService;
//	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach:inside inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach:inside inside setter method - setEmailaddress");

		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach:inside inside setter method - setTeam");

		this.team = team;
	}

}
