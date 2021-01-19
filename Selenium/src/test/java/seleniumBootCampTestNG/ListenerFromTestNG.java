package seleniumBootCampTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerFromTestNG implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Before Start of Test" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("After Finish of Test" + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failure" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skip" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Fail on Success percentage" + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test failed due to time out" + result.getMethod().getMethodName());
	}

}
