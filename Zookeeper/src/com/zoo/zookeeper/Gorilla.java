package com.zoo.zookeeper;

public class Gorilla extends Mammal{
	
	public Gorilla(int energyLevel) {
		super(energyLevel);
		// TODO Auto-generated constructor stub
	}

	public void throwSomething() {
		energyLevel -=5;
		System.out.println("The gorilla threw something!");
	}
	
	public void eatBananas() {
		energyLevel +=10;
		System.out.println("The gorilla ate a banana! It is very satisfied.");
	}
	
	public void climb() {
		energyLevel -=10;
		System.out.println("The gorilla just climbed a tree!");
		
	}

}
