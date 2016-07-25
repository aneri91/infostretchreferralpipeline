package com.infostretch.referral;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SecondJUnitTest {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(FirstJUnitTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("Both tests have been passed successfully");
		}
}
}
