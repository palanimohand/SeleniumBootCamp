package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class SalesforceRolePage extends BeforeExecution {
	
	By salesforceArchitect = By.xpath("//div[text()='Salesforce Architect']");
	By technicalArchitect = By.xpath("//a[text()='Technical Architect']//preceding::a[text()='More Details']");
	
	public SalesforceRolePage(RemoteWebDriver driver){
		this.driver = driver;
	}
	
	public SalesforceRolePage clickSalesforceArchitect() {
		click(salesforceArchitect);
		return this;
	}
	
	public TechnicalArchitectPage clickTechnicalArchitect() {
		click(technicalArchitect);
		switchToNextNewWindow();
		return new TechnicalArchitectPage(driver);
	}

}
