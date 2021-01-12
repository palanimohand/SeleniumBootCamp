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

public class S20_31_DeleteTask extends BeforeExecution{

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

	@Test(dependsOnMethods = { "seleniumBootCampTestNG.S20_30_EditTask.editTask" })
	public void deletetask() throws InterruptedException {

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

		WebElement deletedd = driver.findElementByXPath("//div[@title='Delete']");

		action.click(deletedd).build().perform();

		Thread.sleep(3000);

		driver.findElementByXPath("//span[text()='Delete']").click();

		Thread.sleep(3000);

		String text = driver.findElementByXPath("//div[starts-with(@class,'toastContent')]/div/span").getText();

		if (text.contains("Task") && text.contains("was deleted")) {
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
