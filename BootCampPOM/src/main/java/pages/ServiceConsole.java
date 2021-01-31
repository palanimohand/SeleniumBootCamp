package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class ServiceConsole extends BeforeExecution {

	By navigationMenu = By.xpath("//button[@title='Show Navigation Menu']");
	By refunds = By.xpath("//span[text()='Refunds' and starts-with(@class,'menuLabel')]");
	By home = By.xpath("//span[text()='Home' and starts-with(@class,'menuLabel')]");
	By dashboard = By.xpath("//span[text()='Dashboards' and starts-with(@class,'menuLabel')]");
	By selectVanish = By.xpath("//div[contains(@class,'selectedListItem')]");

	public ServiceConsole(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public ServiceConsole clickNavigationMenu() throws InterruptedException {
		Thread.sleep(2000);
		waitToBeInvisible(selectVanish, "Select...");
		click(navigationMenu);
		return this;
	}

	public RefundListingPage clickRefund() {
		click(refunds);
		return new RefundListingPage(driver);
	}

	public ServiceConsoleHome clickHome() {
		click(home);
		return new ServiceConsoleHome(driver);
	}

	public DashboardListingPage clickDashboard() {
		click(dashboard);
		return new DashboardListingPage(driver);
	}

}
