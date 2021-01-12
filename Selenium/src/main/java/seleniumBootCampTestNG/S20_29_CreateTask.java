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

public class S20_29_CreateTask extends BeforeExecution{

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
	public void createTask() throws InterruptedException {

		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		Thread.sleep(20000);

		driver.findElementByXPath("//a[starts-with(@class,'globalCreateTrigger')]").click();

		Thread.sleep(4000);

		driver.findElementByXPath("//a[@title='New Task']").click();

		Thread.sleep(2000);

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys("Sarath M");

		Thread.sleep(1000);

		driver.findElementByXPath("//div[@title='Sarath M']").click();

		driver.findElementByXPath("//span[text()='Status']//parent::span//following::a[1]").click();

		driver.findElementByXPath("//a[@title='Waiting on someone else']").click();

		driver.findElementByXPath("//label[text()='Subject']//parent::label//following::input[1]")
				.sendKeys("Boot Camp");

		driver.findElementByXPath("//button[contains(@class,'publisherShareButton')]").click();

		Thread.sleep(3000);

		String txt = driver.findElementByXPath("//span[contains(@class,'forceActionsText')]").getText();

		System.out.println(txt);

		if (txt.contains("Task") && txt.contains("was created")) {
			System.out.println("Match");
		} else {
			System.out.println("MisMatch");
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
