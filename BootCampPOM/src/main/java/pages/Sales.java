package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class Sales extends BeforeExecution {
	
	By opportunityDD = By.xpath("//a[@title='Opportunities']");
	By newOption = By.xpath("//a[@title='New']");
	By task = By.xpath("//a[@title='Tasks']");
	By taskDD = By.xpath("//a[@title='Tasks']//following::a");
	By newTask = By.xpath("//span[text()='New Task']//ancestor::a");

	public Sales(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public Sales clickOpportunityDropDown() throws InterruptedException {
		Thread.sleep(2000);
		javaScriptClick(opportunityDD);
		return this;
	}

	public NewOpportunity clickNewOption() {
		click(newOption);
		return new NewOpportunity(driver);
	}
	
	public TaskListingPage clickTasks() {
		actionClick(task);
		return new TaskListingPage(driver);
	}
	
	public Sales clickTasksDD() {
		actionClick(taskDD);
		return this;
	}
	
	public NewFullTaskPage clickNewTask() {
		actionClick(newTask);
		return new NewFullTaskPage(driver);
	}
	
	

}
