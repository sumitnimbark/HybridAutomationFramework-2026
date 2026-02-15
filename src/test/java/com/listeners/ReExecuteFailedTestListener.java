package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReExecuteFailedTestListener implements IRetryAnalyzer {
	
	private static int count = 0;
	private static final int MAX_RETRY = 2;

	@Override
	public boolean retry(ITestResult result) {
		if(count <= MAX_RETRY)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
