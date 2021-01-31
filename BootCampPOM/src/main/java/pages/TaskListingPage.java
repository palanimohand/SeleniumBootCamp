package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class TaskListingPage extends BeforeExecution{
	
	By listingDisplay = By.xpath("//a[contains(@class,'downIcon')]");
	By recentlyViewed = By.xpath("//li[contains(@class,'slds-dropdown')]//span[text()='Recently Viewed']");
	By moreActions = By.xpath("//a[@title='Show 13 more actions']");
	By edit = By.xpath("//div[@title='Edit']");
	By delete = By.xpath("//div[@title='Delete']");
	By deletewarn = By.xpath("//span[text()='Delete']");
	By taskSubject = By.xpath("//span[text()='Subject']//parent::div//following-sibling::div/span");
	
	public TaskListingPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public TaskListingPage clickListDropDown() {
		click(listingDisplay);
		return this;
	}
	
	public TaskListingPage clickRecentlyViewed() {
		click(recentlyViewed);
		return this;
	}
	
	public TaskListingPage clickMoreActions() {
		click(moreActions);
		return this;
	}
	
	public EditTaskPage clickEditOption() {
		actionClick(edit);
		return new EditTaskPage(driver);
	}
	
	public TaskListingPage clickDeleteOption() {
		actionClick(delete);
		return this;
	}
	
	public Home clickDeleteWarn() {
		click(deletewarn);
		return new Home(driver);
	}
	
	public String getTaskSubject() {
		return getText(taskSubject);
	}
	
}
