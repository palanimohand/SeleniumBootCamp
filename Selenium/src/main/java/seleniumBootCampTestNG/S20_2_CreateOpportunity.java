package seleniumBootCampTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class S20_2_CreateOpportunity extends BeforeExecution{
	
	@BeforeSuite
	private void beforesuite() {
		System.out.println("Before Suite");
	}

	@BeforeTest
	private void beforeTest() {
		System.out.println("Before Test");
	}

	@BeforeClass
	private void beforeClass() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void start(String browser) {
		launchBrowser(browser);
	}

	@Test
	public void createOpportunity() throws InterruptedException {

		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		Thread.sleep(20000);

		driver.findElementByClassName("slds-icon-waffle").click();

		Thread.sleep(4000);

		driver.findElementByXPath("//button[@class='slds-button']").click();

		Thread.sleep(10000);

		driver.findElementByXPath("//p[text()='Sales']").click();

		Thread.sleep(10000);

		WebElement oppDropDown = driver.findElementByXPath("//a[@title='Opportunities']");

		Thread.sleep(3000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", oppDropDown);

		Thread.sleep(5000);

		driver.findElementByXPath("//a[@title='New']").click();

		Thread.sleep(3000);
		
		String oppname = "Salesforce Automation by Palanimohan";

		driver.findElementByXPath("//span[text()='Opportunity Name']//parent::label//following-sibling::input")
				.sendKeys(oppname);

		driver.findElementByXPath("//span[text()='Close Date']//parent::label//following-sibling::div/input").click();

		driver.findElementByXPath("//button[text()='Today']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Stage' and (not(contains(@title,'Stage')))]//parent::span//following::div[1]").click();

		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[@title='Needs Analysis']").click();
		
		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();
		
		Thread.sleep(10000);
		
		String scannedtext = driver.findElementByXPath("//div[@class='slds-media__body']/h1/div//following::slot/slot/lightning-formatted-text").getText();
		
		if(scannedtext.trim().equals(oppname.trim())) {
			System.out.println("Name Match");
		}else {
			System.out.println("Name mismatch");
		}
		
	}
	
	@AfterMethod
	public void finish() {
		driver.quit();
	}

	@AfterClass
	public void afterclass() {
		System.out.println("After Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("After Suite");
	}

}
