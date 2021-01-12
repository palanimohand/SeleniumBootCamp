package seleniumBootCampTestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class S20_30_EditTask extends BeforeExecution {
	
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

	@Test(dependsOnMethods = {"seleniumBootCampTestNG.S20_29_CreateTask.createTask"})
	public void editTask() throws InterruptedException {

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

		WebElement taskdd = driver.findElementByXPath("//a[@title='Tasks']");

		Actions action = new Actions(driver);

		action.click(taskdd).build().perform();

		Thread.sleep(4000);

		driver.findElementByXPath("//a[contains(@class,'downIcon')]").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//li[contains(@class,'slds-dropdown')]//span[text()='Recently Viewed']").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//a[@title='Show 13 more actions']").click();

		Thread.sleep(2000);

		WebElement editdd = driver.findElementByXPath("//div[@title='Edit']");

		action.click(editdd).build().perform();

		Thread.sleep(3000);

		driver.findElementByXPath("//span[text()='Due Date']//parent::label//following-sibling::div/input").click();

		driver.findElementByXPath("//button[text()='Today']").click();

		driver.findElementByXPath("//span[text()='Priority']//parent::span//following::div[@class='uiMenu'][2]")
				.click();

		Thread.sleep(1000);

		driver.findElementByXPath("//a[@title='Low']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();

		Thread.sleep(10000);

		String text = driver.findElementByXPath("//span[text()='Subject']//parent::div//following-sibling::div/span")
				.getText();

		if (text.equals("Boot Camp")) {
			System.out.println(text + ": Subject Match");
		} else {
			System.out.println(text + ": Subject Mismatch");
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
