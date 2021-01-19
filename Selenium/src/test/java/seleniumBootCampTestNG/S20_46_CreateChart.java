package seleniumBootCampTestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class S20_46_CreateChart extends BeforeExecution {

	@Test(groups = { "chart" }, dataProvider = "provideData")
	public void createChart(String browser, String username, String password, String url) throws InterruptedException {

		launchBrowser(browser);
		driver.get(url);

		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementById("Login").click();

		waitToBeClickable(By.className("slds-icon-waffle"));

		driver.findElementByClassName("slds-icon-waffle").click();

		waitToBeClickable(By.xpath("//button[@class='slds-button']"));

		driver.findElementByXPath("//button[@class='slds-button']").click();

		waitToBeClickable(By.xpath("//p[text()='Service Console']"));

		driver.findElementByXPath("//p[text()='Service Console']").click();

		waitToBeClickable(By.xpath("//button[@title='Show Navigation Menu']"));

		driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();

		waitToBeClickable(By.xpath("//span[text()='Refunds' and starts-with(@class,'menuLabel')]"));

		driver.findElementByXPath("//span[text()='Refunds' and starts-with(@class,'menuLabel')]").click();

		waitToBeClickable(By.xpath("//span[text()='Recently Viewed']//parent::div//following-sibling::a"));

		driver.findElementByXPath("//span[text()='Recently Viewed']//parent::div//following-sibling::a").click();

		waitToBeClickable(By.xpath("//span[text()='All']"));

		driver.findElementByXPath("//span[text()='All']").click();

		waitToBeClickable(By.xpath("//button[@title='Show charts']"));

		driver.findElementByXPath("//button[@title='Show charts']").click();

		waitToBeClickable(By.xpath("//a[@title='Settings']/lightning-icon"));

		driver.findElementByXPath("//a[@title='Settings']/lightning-icon").click();

		waitToBeClickable(By.xpath("//a[@title='New Chart']"));

		driver.findElementByXPath("//a[@title='New Chart']").click();

		waitToBeClickable(By.xpath("//span[text()='Chart Name']//parent::label//following-sibling::input"));

		driver.findElementByXPath("//span[text()='Chart Name']//parent::label//following-sibling::input")
				.sendKeys("Practice Chart");

		driver.findElementByXPath("//span[text()='Chart Type']//parent::span//following-sibling::div/div/div/div/a")
				.click();

		driver.findElementByXPath("//li[contains(@class,'uiRadioMenuItem')]/a[@title='Vertical Bar Chart']").click();

		driver.findElementByXPath("//span[text()='Aggregate Type']//parent::span//following-sibling::div/div/div/div/a")
				.click();

		driver.findElementByXPath("//a[@title='Average']").click();

		driver.findElementByXPath(
				"//span[text()='Aggregate Field']//parent::span//following-sibling::div/div/div/div/a").click();

		driver.findElementByXPath("//a[@title='Amount']").click();

		driver.findElementByXPath("//span[text()='Grouping Field']//parent::span//following-sibling::div/div/div/div/a")
				.click();

		driver.findElementByXPath("//a[@title='Account']").click();

		driver.findElementByXPath("//button[@title='Save']").click();

		waitToBeInvisible(By.xpath("//button[@title='Save']"));

		driver.findElementByXPath("//a[@title='Settings']/lightning-icon").click();

		waitToBeClickable(By.xpath("//a[@title='Horizontal Bar Chart']"));

		driver.findElementByXPath("//a[@title='Horizontal Bar Chart']").click();

		Thread.sleep(5000);

	}

}