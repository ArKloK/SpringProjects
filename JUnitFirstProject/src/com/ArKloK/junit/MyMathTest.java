package com.ArKloK.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	
	MyMath math = new MyMath();

	@Test
	void calculateSumThreeMemberArray() {
		
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
	}
	
	@Test
	void calculateSumCeroMemberArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}

}
