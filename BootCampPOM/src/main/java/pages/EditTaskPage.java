package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class EditTaskPage extends BeforeExecution{
	
	By duedate = By.xpath("//span[text()='Due Date']//parent::label//following-sibling::div/input");
	By today = By.xpath("//button[text()='Today']");
	By priority = By.xpath("//span[text()='Priority']//parent::span//following::div[@class='uiMenu'][2]");
	By low = By.xpath("//a[@title='Low']");
	By save = By.xpath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']");
	
	public EditTaskPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public EditTaskPage clickDueDate() {
		click(duedate);
		return this;
	}
	
	public EditTaskPage clickToday() {
		click(today);
		return this;
	}
	
	public EditTaskPage clickPriority() {
		click(priority);
		return this;
	}
	
	public EditTaskPage clickLow() {
		click(low);
		return this;
	}
	
	public TaskListingPage clickSave() {
		click(save);
		return new TaskListingPage(driver);
	}

}
