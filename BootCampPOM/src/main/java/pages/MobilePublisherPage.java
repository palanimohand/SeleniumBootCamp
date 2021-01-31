package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class MobilePublisherPage extends BeforeExecution{
	
	By resources = By.xpath("//span[text()='Resources']//parent::button");
	By certificate = By.xpath("//span[text()='Salesforce Certification ']//parent::a");
	
	public MobilePublisherPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public MobilePublisherPage moveToResources() {
		moveToElement(resources);
		return this;
	}
	
	
	public SalesforceRolePage clickCertificate() {
		click(certificate);
		switchToNextNewWindow();
		return new SalesforceRolePage(driver);
	}

}
