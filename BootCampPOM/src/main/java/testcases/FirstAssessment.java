package testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import pages.DashBoardDetailsPage;
import pages.DashboardListingPage;
import pages.Login;
import pages.ServiceConsole;
import pages.ServiceConsoleHome;
import utils.BeforeExecution;

public class FirstAssessment extends BeforeExecution {
	
	@BeforeClass(alwaysRun = true)
	public void setData() {
		sheetName = "Dashboard";
	}

	@Test(groups = "service console", dataProvider = "provideData")
	public void createAndDeleteDashboard(String browser, String userName, String passWord, String url, String goal, String dashName, String dashDesc, String time)
			throws InterruptedException {

		launchBrowser(browser);
		get(url);
		
		new Login(driver).enterUserName(userName)
		.enterPassword(passWord)
		.clickOnLogin()
		.clickAppLauncherBtn()
		.clickAllAppsLink()
		.openServiceConsole()
		.clickNavigationMenu()
		.clickHome();
		
		ServiceConsoleHome sch = new ServiceConsoleHome(driver);
		
		int parseInt = Integer.parseInt(sch.getOpenCount().replace("$", ""));
		int parseInt2 = Integer.parseInt(sch.getCloseCount().replace("$", ""));
		
		int sum1 = parseInt + parseInt2;
		
		if (sum1 < 10000) {
			enterGoal(goal);
		} else {
			enterGoal(String.valueOf(sum1));
		}
		
		Random rm = new Random();
		int random1 = rm.nextInt(1000);
		
		new ServiceConsole(driver).clickNavigationMenu()
		.clickDashboard()
		.clickNewDash()
		.enterDashboardName(dashName + random1)
		.enterDashboardDesc(dashDesc)
		.clickOnSave()
		.clickDone();
		
		DashBoardDetailsPage ddp = new DashBoardDetailsPage(driver);
		
		String dashTitle2 = ddp.getDashTitle();
		String dashDesc2 = ddp.getDashDesc();
		
		Assertion asser = new Assertion();
		
		boolean b1 = dashTitle2.equals(dashName + random1);
		boolean b2 = dashDesc2.equals(dashDesc);
		asser.assertEquals(b1&&b2, true, "The dashboard has not been created");
		
		String toastMessage = ddp.clickOnSubscribe()
		.clickDaily()
		.selectTime(time)
		.clickOnSave()
		.getToastMessage();
		
		asser.assertEquals(toastMessage, "You started a dashboard subscription.");
		
		ddp.closeDashboardicon();
		
		List<WebElement> searchResult = new ServiceConsole(driver)
		.clickNavigationMenu()
		.clickDashboard()
		.clickPrivateDash()
		.enterSearch(dashName + random1)
		.getSearchResult();
		
		if (searchResult.size() > 1) {
			System.out.println("Incorrect search result");
		} else if (searchResult.size() == 1) {
			String webElement = searchResult.get(0).getText();
			while (webElement.equals(dashName + random1)) {
				System.out.println("Correct result");
				break;
			}
		}
		
		String noResMessage = new DashboardListingPage(driver).clickItemDropDown()
		.clickDelete()
		.clickDeleteConfirm()
		.enterSearch(dashName + random1)
		.getNoResMessage();
		
		asser.assertEquals(noResMessage, "No results found", "Fail, not deleted");
	
	}
	
	public void enterGoal(String n) {
		new ServiceConsoleHome(driver).clickEditGoalValue().enterGoalValue(n).saveGoalValue();
	}
	
}
