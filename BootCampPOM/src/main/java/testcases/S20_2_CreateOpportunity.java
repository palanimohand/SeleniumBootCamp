package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.BeforeExecution;

public class S20_2_CreateOpportunity extends BeforeExecution {

	@BeforeClass
	public void setData() {
		sheetName = "Create Opportunity";
	}
	
	@Test(groups = "easy", dataProvider = "provideData")
	public void createOpportunity(String browser, String username, String password, String url, String oppName)
			throws InterruptedException {

		String oppName2 = new Login(driver).launchApplication(browser, url)
		.enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickAppLauncherBtn()
		.clickAllAppsLink()
		.openSales()
		.clickOpportunityDropDown()
		.clickNewOption()
		.enterOppName(oppName)
		.clickCloseDate()
		.clickToday()
		.clickStage()
		.clickNeedAnalysis()
		.clickSave()
		.getOppName();
		
		if (oppName2.trim().equals(oppName)) {
			System.out.println("Name Match");
		} else {
			System.out.println("Name mismatch");
		}

	}

}
