package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class NewTaskPage extends BeforeExecution {

	By taskName = By.xpath("//span[text()='Name']//parent::label//following::input[1]");
	By status = By.xpath("//span[text()='Status']//parent::span//following::a[1]");
	By wfseOption = By.xpath("//a[@title='Waiting on someone else']");
	By subject = By.xpath("//label[text()='Subject']//parent::label//following::input[1]");
	By save = By.xpath("//button[contains(@class,'publisherShareButton')]");
	
	public NewTaskPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public NewTaskPage selectTaskName(String text) {
		type(taskName, text);
		click(By.xpath("//div[@title='"+text+"']"));
		return this;
	}
	
	public NewTaskPage clickStatus() {
		click(status);
		return this;
	}
	
	public NewTaskPage clickWfseOption() {
		click(wfseOption);
		return this;
	}
	
	public NewTaskPage enterSubject(String text) {
		type(subject, text);
		return this;
	}
	
	public Home clickSave() {
		click(save);
		return new Home(driver);
	}
}
