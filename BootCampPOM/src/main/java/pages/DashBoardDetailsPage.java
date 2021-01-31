package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class DashBoardDetailsPage extends BeforeExecution {

	By dashTitle = By.xpath("//span[starts-with(@class,'slds-page-header__title')]");
	By dashDesc = By.xpath("//p[@class='slds-page-header__info']");
	By subscribe = By.xpath("//button[text()='Subscribe']");
	By toastMessage = By.xpath("//span[contains(@class,'toastMessage')]");
	By closeDashBoard = By.xpath("(//div[contains(@class,'close')])[last()]/button");

	public DashBoardDetailsPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public String getDashTitle() {
		return getText(dashTitle);
	}

	public String getDashDesc() {
		return getText(dashDesc);
	}

	public SubscribePage clickOnSubscribe() {
		click(subscribe);
		driver.switchTo().defaultContent();
		return new SubscribePage(driver);
	}

	public String getToastMessage() {
		return getText(toastMessage);
	}

	public DashBoardDetailsPage closeDashboardicon() {
		click(closeDashBoard);
		return this;
	}

}
