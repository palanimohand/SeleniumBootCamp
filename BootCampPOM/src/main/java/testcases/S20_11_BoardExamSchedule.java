package testcases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.TechnicalArchitectPage;
import utils.BeforeExecution;

public class S20_11_BoardExamSchedule extends BeforeExecution {
	
	@BeforeClass
	public void setData() {
		sheetName = "Board Exam Schedule";
	}

	@Test(groups = "easy",dataProvider = "provideData")
	public void plannedBoardExam(String browser, String username, String password, String url) throws InterruptedException {

		TechnicalArchitectPage ta = new Login(driver)
		.launchApplication(browser, url)
		.enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickMPLearnMore()
		.moveToResources()
		.clickCertificate()
		.clickSalesforceArchitect()
		.clickTechnicalArchitect();
		
		List<WebElement> scheduleFullTable2 = ta.getScheduleFullTable();
		List<WebElement> statusFullTable = ta.getStatusFullTable();
		
		System.out.println("Planned Schedule details: ");
		for (int i = 0; i < statusFullTable.size(); i++) {
			if (statusFullTable.get(i).getText().trim().equals("Planning")) {
				System.out.println("City: " + ta.getCity(scheduleFullTable2.get(i + 1)));
				System.out.println("Date: " + ta.getDatesAvl(scheduleFullTable2.get(i + 1)));
			}
		}
	}
}
