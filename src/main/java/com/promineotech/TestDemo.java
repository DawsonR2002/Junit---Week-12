package com.promineotech;

import java.util.Random;

public class TestDemo {

	
	public int addPositive(int a, int b) {
		try {
				if(a > 0 && b > 0) {
					return a + b;
				}
				
				throw new IllegalArgumentException("Both parameters must be positive!");
			}
		
			catch (IllegalArgumentException e) {
			
			throw e;
			}
		
	}
	
	public int addNegative(int a, int b) {
		
		try {
				//are both numbers negative
				if(a < 0 && b < 0) {
					//return their sum
					return a + b;
				}
				
				//return an exception
				throw new IllegalArgumentException("Both parameters must be negative!");
			}
		
			catch (IllegalArgumentException e) {
			
			throw e;
			}
		
	}
	
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}
	
	int getRandomInt() {

	    Random random = new Random();

	    return random.nextInt(10) + 1;

	}
}
