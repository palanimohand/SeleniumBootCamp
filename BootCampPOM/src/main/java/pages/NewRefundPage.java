package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class NewRefundPage extends BeforeExecution{
		
	By accounts = By.xpath("//input[@title='Search Accounts']");
	By accountOption = By.xpath("//li[starts-with(@class,'lookup')][1]");
	By status = By.xpath("//span[text()='Status']//parent::span//following-sibling::div[@class='uiMenu']");
	By cancelledOption = By.xpath("//a[@title='Canceled']");
	By amount = By.xpath("//span[text()='Amount']//parent::label//following-sibling::input");
	By type = By.xpath("//span[text()='Type']//parent::span//following-sibling::div[@class='uiMenu']");
	By referencedOption = By.xpath("//a[@title='Referenced']");
	By processingMode = By.xpath("//span[text()='Processing Mode']//parent::span//following-sibling::div[@class='uiMenu']");
	By externalOption = By.xpath("//a[@title='External']");
	By save = By.xpath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']");
	
	public NewRefundPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public NewRefundPage clickAccount() {
		click(accounts);
		return this;
	}
	
	public NewRefundPage clickAccountOption() {
		click(accountOption);
		return this;
	}
	
	public NewRefundPage clickStatus() {
		click(status);
		return this;
	}
	
	public NewRefundPage clickCancelledOption() {
		click(cancelledOption);
		return this;
	}

	public NewRefundPage enterAmount(String number) {
		type(amount, number);
		return this;
	}
	
	public NewRefundPage clickType() {
		click(type);
		return this;
	}
	
	public NewRefundPage clickReferencedOption() {
		click(referencedOption);
		return this;
	}
	
	public NewRefundPage clickProcessingMode() {
		click(processingMode);
		return this;
	}
	
	public NewRefundPage clickExternal() {
		click(externalOption);
		return this;
	}
	
	public NewRefundPage clickSave() {
		click(save);
		return this;
	}
}
