package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class DashAfterCreate extends BeforeExecution{
	
	By done = By.xpath("//button[@class='slds-button doneEditing']");
	
	public DashAfterCreate(RemoteWebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		this.driver = driver;
		waitForFrame(By.xpath("(//iframe[@title='dashboard'])[last()]"));
	}
	
	public DashBoardDetailsPage clickDone() {
		click(done);
		return new DashBoardDetailsPage(driver);
	}

}
