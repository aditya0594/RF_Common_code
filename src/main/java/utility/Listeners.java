package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test is started"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		try {
			Screenshot.takesScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestPass(ITestResult result)
	{
		try {
			Screenshot.takesScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test is passed"+result.getName());
	}
	
	public void onTestSkip(ITestResult result)
	{
		System.out.println("Test is skipped"+result.getName());
	}

}
