package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class SubscribePage extends BeforeExecution{
	
	By daily = By.xpath("//span[contains(@class,'button-group-button-label') and text()='Daily']");
	By time = By.tagName("select");
	By save = By.xpath("//span[text()='Save']");
	
	public SubscribePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public SubscribePage clickDaily() {
		click(daily);
		return this;
	}

	public SubscribePage selectTime(String text) {
		selectByVisibleText(time, text);
		return this;
	}
	
	public DashBoardDetailsPage clickOnSave() {
		click(save);
		return new DashBoardDetailsPage(driver);
	}

}
