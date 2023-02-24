package com.zoo.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gorilla silverback = new Gorilla(100);
		
		for(int i = 0; i<3; i++) {
			silverback.throwSomething();
		}
		
		for(int i = 0; i<2; i++) {
			silverback.eatBananas();
		}
		
		silverback.climb();
		
		silverback.displayEnergy();

	}

}
