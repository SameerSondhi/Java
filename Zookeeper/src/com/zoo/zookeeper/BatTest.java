package com.zoo.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bat vampire = new Bat(300);
		
		for(int i = 0; i<3; i++) {
			vampire.attackTown();
		}
		
		for(int i = 0; i<2; i++) {
			vampire.eatHumans();
		}
		
		for(int i = 0; i<2; i++) {
			vampire.fly();
		}
		
		vampire.displayEnergy();
	}

}
