package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.BeforeExecution;

public class NewOpportunity extends BeforeExecution{
	
	By oppName = By.xpath("//span[text()='Opportunity Name']//parent::label//following-sibling::input");
	By closeDate = By.xpath("//span[text()='Close Date']//parent::label//following-sibling::div/input");
	By today = By.xpath("//button[text()='Today']");
	By stage = By.xpath("//span[text()='Stage' and (not(contains(@title,'Stage')))]//parent::span//following::div[1]");
	By needAnalysis = By.xpath("//a[@title='Needs Analysis']");	
	By save = By.xpath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']");
	
	public NewOpportunity(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public NewOpportunity enterOppName(String text) {
		type(oppName, text);
		return this;
	}
	
	public NewOpportunity clickCloseDate() {
		click(closeDate);
		return this;
	}
	
	public NewOpportunity clickToday() {
		click(today);
		return this;
	}
	
	public NewOpportunity clickStage() {
		click(stage);
		return this;
	}

	public NewOpportunity clickNeedAnalysis() {
		click(needAnalysis);
		return this;
	}
	
	public OpportunityDetails clickSave() {
		click(save);
		return new OpportunityDetails(driver);
	}
}
