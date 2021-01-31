package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class NewDashboardPage extends BeforeExecution{
	
	By dashboardName = By.id("dashboardNameInput");
	By dashboardDesc = By.id("dashboardDescriptionInput");
	By submit = By.id("submitBtn");
	
	public NewDashboardPage(RemoteWebDriver driver) throws InterruptedException {
		this.driver = driver;
	}
	
	public NewDashboardPage enterDashboardName(String text) {
		type(dashboardName, text);
		return this;
	}
	
	public NewDashboardPage enterDashboardDesc(String text) {
		type(dashboardDesc, text);
		return this;
	}
	
	public DashAfterCreate clickOnSave() throws InterruptedException {
		click(submit);
		return new DashAfterCreate(driver);
	}
}
