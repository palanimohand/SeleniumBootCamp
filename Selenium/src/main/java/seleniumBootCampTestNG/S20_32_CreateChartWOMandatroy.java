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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class S20_32_CreateChartWOMandatroy {

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
	public static void createChartWOMandatory() throws InterruptedException {

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

		WebElement taskdd = driver.findElementByXPath("//a[@title='Tasks']//following::a");

		Actions action = new Actions(driver);

		action.click(taskdd).build().perform();

		Thread.sleep(2000);

		WebElement newtask = driver.findElementByXPath("//span[text()='New Task']//ancestor::a");

		action.click(newtask).build().perform();

		Thread.sleep(3000);

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").click();

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys("Sarath M");

		Thread.sleep(1000);

		driver.findElementByXPath("//div[@title='Sarath M']").click();

		driver.findElementByTagName("textarea").sendKeys("SALES FORCE Automation Using Selenium");

		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();

		Thread.sleep(2000);

		String text = driver.findElementByXPath("//ul[@class='errorsList']/li").getText();

		if (text.trim().equalsIgnoreCase("These required fields must be completed: Subject")) {
			System.out.println("Match");
		} else {
			System.out.println("No Match");
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
