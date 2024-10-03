package testNGcommands;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryAnalyser implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 4;

	public boolean retry(ITestResult result) {      //ITestResult describes the result of the test 

			if(counter < retryLimit)
			{
				counter++;
				return true;
			}
			return false;
		}
}
