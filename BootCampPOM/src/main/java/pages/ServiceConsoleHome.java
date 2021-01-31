package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.BeforeExecution;

public class ServiceConsoleHome extends BeforeExecution{
	
	By openCount = By.xpath("//span[@class='metricLabel' and text()='Closed']//following-sibling::span");
	By closeCount = By.xpath("//span[@class='metricLabel' and text()='Open (>70%)']//following-sibling::span");
	By goalTextbox = By.xpath("//input[contains(@class,'uiInputSmartNumber')]");
	By goalValueSave = By.xpath("//span[contains(@class,'bBody') and text()='Save']");
	By editGoal = By.xpath("//button[@title='Edit Goal']");
	
	public ServiceConsoleHome(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public String getOpenCount() {
		return getText(openCount);
	}
	
	public String getCloseCount() {
		return getText(closeCount);
	}
	
	public ServiceConsoleHome clickEditGoalValue() {
		click(editGoal);
		return this;
	}
	
	public ServiceConsoleHome enterGoalValue(String text) {
		type(goalTextbox, text);
		return this;
	}
	
	public ServiceConsoleHome saveGoalValue() {
		click(goalValueSave);
		return this;
	}

}
