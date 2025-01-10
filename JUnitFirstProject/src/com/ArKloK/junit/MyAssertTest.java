package com.ArKloK.junit;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	List<String> todos = Arrays.asList("Aws", "DevOps", "Azure");

	@Test
	void test() {
		boolean test = todos.contains("Aws");
		
		assertEquals(true, test);
		assertEquals(3, todos.size(), "todos does not contain 3 items");
		
		assertTrue("todos contains AWS went wrong", test);
		
		assertArrayEquals(new int[] {1,2}, new int[] {1,2});
	}

}
