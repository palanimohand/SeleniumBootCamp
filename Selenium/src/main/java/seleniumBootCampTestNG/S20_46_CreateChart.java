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
import org.openqa.selenium.remote.RemoteWebDriver;

public class S20_46_CreateChart {

	static RemoteWebDriver driver;

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
		new BeforeExecution().launchBrowser(browser);
	}

	@Test
	public static void createChart() throws InterruptedException {

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

		Thread.sleep(3000);

		driver.findElementByXPath("//span[text()='Refunds' and starts-with(@class,'menuLabel')]").click();

		Thread.sleep(5000);

		driver.findElementByXPath("//span[text()='Recently Viewed']//parent::div//following-sibling::a").click();

		Thread.sleep(5000);

		driver.findElementByXPath("//span[text()='All']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//button[@title='Show charts']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//a[@title='Settings']/lightning-icon").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//a[@title='New Chart']").click();

		Thread.sleep(3000);

		driver.findElementByXPath("//span[text()='Chart Name']//parent::label//following-sibling::input")
				.sendKeys("Practice Chart");

		driver.findElementByXPath("//span[text()='Chart Type']//parent::span//following-sibling::div/div/div/div/a")
				.click();

		Thread.sleep(1000);

		driver.findElementByXPath("/html/body/div[9]/div/ul/li[1]/a").click();

		driver.findElementByXPath("//span[text()='Aggregate Type']//parent::span//following-sibling::div/div/div/div/a")
				.click();

		Thread.sleep(1000);

		driver.findElementByXPath("/html/body/div[10]/div/ul/li[1]/a").click();

		driver.findElementByXPath(
				"//span[text()='Aggregate Field']//parent::span//following-sibling::div/div/div/div/a").click();

		Thread.sleep(1000);

		driver.findElementByXPath("/html/body/div[11]/div/ul/li[2]/a").click();

		driver.findElementByXPath("//span[text()='Grouping Field']//parent::span//following-sibling::div/div/div/div/a")
				.click();

		Thread.sleep(1000);

		driver.findElementByXPath("/html/body/div[12]/div/ul/li[1]/a").click();

		driver.findElementByXPath("//button[@title='Save']").click();

		Thread.sleep(5000);

		driver.findElementByXPath("//a[@title='Settings']/lightning-icon").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//a[@title='Horizontal Bar Chart']").click();

		Thread.sleep(5000);

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
