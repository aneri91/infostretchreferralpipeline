package com.infostretch.referral;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstJUnitTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}

	@Before
	public void before() {
		System.out.println("Before");
	}

	public int addition(int x, int y) {
		return x + y;
	}

	@Test
	public void testingCrunchifyAddition() {
		System.out.println("testingCrunchifyAddition");
		assertEquals("Here is test for Addition Result: ", 30, addition(27, 3));
	}

	public String helloWorld() {
		String helloWorld = "Hello +" + " World";
		return helloWorld;
	}

	@Test
	public void testingHelloWorld() {
		System.out.println("testingHelloWorld");
		assertEquals("Here is test for Hello World String: ", "Hello + World", helloWorld());
	}

	public static int maxFromArray(int array[]) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	@Test
	public void testingMaxFromArray() {
		System.out.println("testingMaxFromArray");
		assertEquals("Here is test for maxnium number from an array list", 11,
				maxFromArray(new int[] { 1, 4, 11, 10 }));
	}

	public static int cubeNumber(int i) {
		return i * i * i;
	}

	@Test
	public void testingCubeNumber() {
		System.out.println("testingCubeNumber");
		assertEquals("Here is testing for cube", 1000, cubeNumber(10));
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

	@After
	public void after() {
		System.out.println("After");
	}
}