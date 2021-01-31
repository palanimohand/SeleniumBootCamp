package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.Login;
import utils.BeforeExecution;

public class S20_30_EditTask extends BeforeExecution {

	@BeforeClass(alwaysRun = true)
	public void setData() {
		sheetName = "Edit Task";
	}
	
	@Test(groups = { "a" }, dataProvider = "provideData")
	public void editTask(String browser, String username, String password, String url) throws InterruptedException {

		launchBrowser(browser);
		get(url);
		
		String taskSubject = new Login(driver).enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickAppLauncherBtn()
		.clickAllAppsLink()
		.openSales()
		.clickTasks()
		.clickListDropDown()
		.clickRecentlyViewed()
		.clickMoreActions()
		.clickEditOption()
		.clickDueDate()
		.clickToday()
		.clickPriority()
		.clickLow()
		.clickSave()
		.getTaskSubject();
		
		Assertion asse = new Assertion();
		asse.assertEquals(taskSubject, "Boot Camp");

	}

}
