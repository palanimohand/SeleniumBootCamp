package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.BeforeExecution;

public class S20_45_CreateRefund extends BeforeExecution {

	@BeforeClass(alwaysRun = true)
	public void setData() {
		sheetName = "Create Refund";
	}
	
	@Test(groups = "service console", dataProvider = "provideData")
	public void createRefund(String browser, String username, String password, String url, String amount) throws InterruptedException {

		launchBrowser(browser);
		get(url);
		
		new Login(driver).enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickAppLauncherBtn()
		.clickAllAppsLink()
		.openServiceConsole()
		.clickNavigationMenu()
		.clickRefund()
		.clickNewRefund()
		.clickAccount()
		.clickAccountOption()
		.clickStatus()
		.clickCancelledOption()
		.enterAmount(amount)
		.clickType()
		.clickReferencedOption()
		.clickProcessingMode()
		.clickExternal()
		.clickSave();

		Thread.sleep(2000);

	}
}