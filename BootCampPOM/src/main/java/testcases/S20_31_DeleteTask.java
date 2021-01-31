package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.BeforeExecution;

public class S20_31_DeleteTask extends BeforeExecution {

	@BeforeClass(alwaysRun = true)
	public void setData() {
		sheetName = "Delete Task";
	}
	
	@Test(groups = { "a" }, dataProvider = "provideData")
	public void deletetask(String browser, String username, String password, String url) throws InterruptedException {

		launchBrowser(browser);
		get(url);
		
		String readDeleteMessage = new Login(driver).enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickAppLauncherBtn()
		.clickAllAppsLink()
		.openSales()
		.clickTasks()
		.clickListDropDown()
		.clickRecentlyViewed()
		.clickMoreActions()
		.clickDeleteOption()
		.clickDeleteWarn()
		.readDeleteMessage();
		
		if (readDeleteMessage.contains("Task") && readDeleteMessage.contains("was deleted")) {
			System.out.println("Match");
		} else {
			System.out.println("MisMatch");
		}

	}

}
