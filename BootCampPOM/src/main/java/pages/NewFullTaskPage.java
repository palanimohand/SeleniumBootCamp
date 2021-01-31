package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class NewFullTaskPage extends BeforeExecution{
	
	By taskName = By.xpath("//span[text()='Name']//parent::label//following::input[1]");
	By comment = By.tagName("textarea");
	By save = By.xpath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']");
	By wmessage = By.xpath("//ul[@class='errorsList']/li");
	
	public NewFullTaskPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public NewFullTaskPage enterTaskName(String name) {
		type(taskName, name);
		return this;
	}
	
	public NewFullTaskPage clickTaskName(String name) throws InterruptedException {
		Thread.sleep(2000);
		click(By.xpath("//div[@title='"+name+"']"));
		return this;
	}
	
	public NewFullTaskPage enterComment(String comments) {
		type(comment, comments);
		return this;
	}
	
	public NewFullTaskPage clickOnSaveWOMan() {
		click(save);
		return this;
	}
	
	public String getErrorMessage() {
		return getText(wmessage);
	}
	
}
