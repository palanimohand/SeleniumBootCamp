package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.Login;
import utils.BeforeExecution;

public class S20_32_CreateTaskWOMandatroy extends BeforeExecution {

	@BeforeClass(alwaysRun = true)
	public void setData() {
		sheetName = "Create Chart Man";
	}
	
	@Test(groups = { "chart" }, dataProvider = "provideData")
	public void createChartWOMandatory(String browser, String username, String password, String url, String taskName, String comment) throws InterruptedException {

		launchBrowser(browser);
		get(url);
		
		String errorMessage = new Login(driver).enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickAppLauncherBtn()
		.clickAllAppsLink()
		.openSales()
		.clickTasksDD()
		.clickNewTask()
		.enterTaskName(taskName)
		.clickTaskName(taskName)
		.enterComment(comment)
		.clickOnSaveWOMan()
		.getErrorMessage();
		
		String expectedMessage = "These required fields must be completed: Subject";
		
		Assertion ass = new Assertion();
		ass.assertEquals(errorMessage, expectedMessage);
		
	}

}
