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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class S20_11_BoardExamSchedule extends BeforeExecution{

	String activeWindow;
	ArrayList<String> allWindows = new ArrayList<String>();
	Set<String> windowHandles;

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
	public void plannedBoardExam() throws InterruptedException {

		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		Thread.sleep(20000);

		driver.findElementByXPath("//div[@class='tileNavButton']/button/span[text()='Learn More']").click();

		switchToNextNewWindow();
		Thread.sleep(3000);
		Actions ac = new Actions(driver);
		WebElement resources = driver.findElementByXPath("//span[text()='Resources']//parent::button");
		WebElement certificate = driver.findElementByXPath("//span[text()='Salesforce Certification ']//parent::a");
		ac.moveToElement(resources).build().perform();
		certificate.click();

		switchToNextNewWindow();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Salesforce Architect']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='Technical Architect']//preceding::a[text()='More Details']").click();

		switchToNextNewWindow();
		Thread.sleep(3000);
		List<WebElement> scheduleFullTable = driver.findElements(By.xpath("//div[starts-with(@class,'slds-grid')]"));
		List<WebElement> status = driver.findElements(
				By.xpath("//div[starts-with(@class,'slds-grid')]/div[text()='Status']//following-sibling::div"));

		System.out.println("Planned Schedule details: ");
		for (int i = 0; i < status.size(); i++) {
			if (status.get(i).getText().trim().equals("Planning")) {
				System.out.println("City: " + ((scheduleFullTable.get(i + 1))
						.findElement(By.xpath("./div[text()='City']//following-sibling::div[1]"))).getText());
				System.out.println("Date: " + ((scheduleFullTable.get(i + 1))
						.findElement(By.xpath("./div[text()='Dates Available']//following-sibling::div[1]")))
								.getText());
			}
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
	
	public void switchToNextNewWindow() {
		windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			while (!allWindows.contains(handle)) {
				allWindows.add(handle);
				driver.switchTo().window(handle);
				break;
			}
		}
	}
}
