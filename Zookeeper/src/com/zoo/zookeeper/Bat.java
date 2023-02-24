package com.zoo.zookeeper;

public class Bat extends Mammal {
	
	public Bat(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}

	public void fly() {
		System.out.println("The bat just took off!");
		energyLevel -= 50;
		
	}
	
	public void eatHumans() {
		System.out.println("...");
		energyLevel +=25;
	}
	
	public void attackTown() {
		System.out.println("Town on fire after bat attack!");
		energyLevel-=100;
	}
}
