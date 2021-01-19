package seleniumBootCampTestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class S20_2_CreateOpportunity extends BeforeExecution {

	@Test(groups = "easy", dataProvider = "provideData")
	public void createOpportunity(String browser, String username, String password, String url) throws InterruptedException {

		launchBrowser(browser);
		driver.get(url);

		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementById("Login").click();

		waitToBeClickable(By.className("slds-icon-waffle"));

		driver.findElementByClassName("slds-icon-waffle").click();

		waitToBeClickable(By.xpath("//button[@class='slds-button']"));

		driver.findElementByXPath("//button[@class='slds-button']").click();

		waitToBeClickable(By.xpath("//p[text()='Sales']"));

		driver.findElementByXPath("//p[text()='Sales']").click();

		waitToBeClickable(By.xpath("//a[@title='Opportunities']"));

		WebElement oppDropDown = driver.findElementByXPath("//a[@title='Opportunities']");

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", oppDropDown);

		waitToBeClickable(By.xpath("//a[@title='New']"));

		driver.findElementByXPath("//a[@title='New']").click();

		waitToBeClickable(By.xpath("//span[text()='Opportunity Name']//parent::label//following-sibling::input"));

		String oppname = "Salesforce Automation by Palanimohan";

		driver.findElementByXPath("//span[text()='Opportunity Name']//parent::label//following-sibling::input")
				.sendKeys(oppname);

		driver.findElementByXPath("//span[text()='Close Date']//parent::label//following-sibling::div/input").click();

		driver.findElementByXPath("//button[text()='Today']").click();

		waitToBeClickable(By
				.xpath("//span[text()='Stage' and (not(contains(@title,'Stage')))]//parent::span//following::div[1]"));

		driver.findElementByXPath(
				"//span[text()='Stage' and (not(contains(@title,'Stage')))]//parent::span//following::div[1]").click();

		waitToBeClickable(By.xpath("//a[@title='Needs Analysis']"));

		driver.findElementByXPath("//a[@title='Needs Analysis']").click();

		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();

		waitToBeClickable(
				By.xpath("//div[@class='slds-media__body']/h1/div//following::slot/slot/lightning-formatted-text"));

		String scannedtext = driver
				.findElementByXPath(
						"//div[@class='slds-media__body']/h1/div//following::slot/slot/lightning-formatted-text")
				.getText();

		if (scannedtext.trim().equals(oppname.trim())) {
			System.out.println("Name Match");
		} else {
			System.out.println("Name mismatch");
		}

	}

	@Test(groups = { "easy" }, enabled = false)
	public void createTask() throws InterruptedException {

		driver.get("https://login.salesforce.com");

		driver.findElementById("username").sendKeys("cypress@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp@123");
		driver.findElementById("Login").click();

		waitToBeClickable(By.xpath("//a[starts-with(@class,'globalCreateTrigger')]"));

		driver.findElementByXPath("//a[starts-with(@class,'globalCreateTrigger')]").click();

		waitToBeClickable(By.xpath("//a[@title='New Task']"));

		driver.findElementByXPath("//a[@title='New Task']").click();

		waitToBeClickable(By.xpath("//span[text()='Name']//parent::label//following::input[1]"));

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys("Sarath M");

		waitToBeClickable(By.xpath("//div[@title='Sarath M']"));

		driver.findElementByXPath("//div[@title='Sarath M']").click();

		driver.findElementByXPath("//span[text()='Status']//parent::span//following::a[1]").click();

		driver.findElementByXPath("//a[@title='Waiting on someone else']").click();

		driver.findElementByXPath("//label[text()='Subject']//parent::label//following::input[1]")
				.sendKeys("Boot Camp");

		driver.findElementByXPath("//button[contains(@class,'publisherShareButton')]").click();

		waitToBeClickable(By.xpath("//span[contains(@class,'forceActionsText')]"));

		String txt = driver.findElementByXPath("//span[contains(@class,'forceActionsText')]").getText();

		System.out.println(txt);

		assertTrue((txt.contains("Task") && txt.contains("was created")), "Match");

		SoftAssert sa = new SoftAssert();

		sa.assertEquals((txt.contains("Task") && txt.contains("was created")), false, "Mismatch is the text");

		System.out.println("Text to be printed");

		assertEquals((txt.contains("Task") && txt.contains("was created")), false, "Mismatch is the text");

		// assertNull(txt);

		// assertSame(txt, txt);

		System.out.println("After Assert Statement");

		sa.assertAll();

	}

}
