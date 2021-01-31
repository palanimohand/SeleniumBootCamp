package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class OpportunityDetails extends BeforeExecution{
	
	By oppTxt = By.xpath("//div[@class='slds-media__body']/h1/div//following::slot/slot/lightning-formatted-text");
	
	public OpportunityDetails(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public String getOppName() {
		return getText(oppTxt);
	}

}
