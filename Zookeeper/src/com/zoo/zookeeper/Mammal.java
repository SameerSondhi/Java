package com.zoo.zookeeper;

public class Mammal {
	public int energyLevel = 100;
	
public Mammal(int energyLevel) {
	this.energyLevel = energyLevel;
}
	public int displayEnergy() {
		System.out.println("This mammal's energy level is: " + energyLevel);
		return energyLevel;
	}

}
