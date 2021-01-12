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

public class S20_45_CreateRefund extends BeforeExecution{

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
	public void createRefund() throws InterruptedException {

		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		Thread.sleep(20000);

		driver.findElementByClassName("slds-icon-waffle").click();

		Thread.sleep(4000);

		driver.findElementByXPath("//button[@class='slds-button']").click();

		Thread.sleep(10000);

		driver.findElementByXPath("//p[text()='Service Console']").click();

		Thread.sleep(10000);

		driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='Refunds' and starts-with(@class,'menuLabel')]").click();

		Thread.sleep(5000);

		driver.findElementByXPath("//a[@title='New']").click();

		Thread.sleep(5000);

		driver.findElementByXPath("//input[@title='Search Accounts']").click();

		driver.findElementByXPath("//li[starts-with(@class,'lookup')][1]").click();

		driver.findElementByXPath("//span[text()='Status']//parent::span//following-sibling::div[@class='uiMenu']")
				.click();

		Thread.sleep(1000);

		driver.findElementByXPath("/html/body/div[8]/div/ul/li[4]/a").click();

		driver.findElementByXPath("//span[text()='Amount']//parent::label//following-sibling::input").sendKeys("50000");

		driver.findElementByXPath("//span[text()='Type']//parent::span//following-sibling::div[@class='uiMenu']")
				.click();

		driver.findElementByXPath("/html/body/div[9]/div/ul/li[2]/a").click();

		driver.findElementByXPath(
				"//span[text()='Processing Mode']//parent::span//following-sibling::div[@class='uiMenu']").click();

		driver.findElementByXPath("/html/body/div[10]/div/ul/li[3]/a").click();

		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();

		Thread.sleep(2000);

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