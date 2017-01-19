package com.example.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(ProductTest.class);
	      System.out.println("run test2");
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println("run test3");
			
	      System.out.println(result.wasSuccessful());
	   }
	
}
