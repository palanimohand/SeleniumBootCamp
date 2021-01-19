package seleniumBootCampTestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class S20_45_CreateRefund extends BeforeExecution {

	@Test(groups = "service console", dataProvider = "provideData")
	public void createRefund(String browser, String username, String password, String url) throws InterruptedException {

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

		waitToBeClickable(By.xpath("//a[@title='New']"));

		driver.findElementByXPath("//a[@title='New']").click();

		waitToBeClickable(By.xpath("//input[@title='Search Accounts']"));

		driver.findElementByXPath("//input[@title='Search Accounts']").click();

		driver.findElementByXPath("//li[starts-with(@class,'lookup')][1]").click();

		driver.findElementByXPath("//span[text()='Status']//parent::span//following-sibling::div[@class='uiMenu']")
				.click();

		driver.findElementByXPath("//a[@title='Canceled']").click();

		driver.findElementByXPath("//span[text()='Amount']//parent::label//following-sibling::input").sendKeys("50000");

		driver.findElementByXPath("//span[text()='Type']//parent::span//following-sibling::div[@class='uiMenu']")
				.click();

		driver.findElementByXPath("//a[@title='Referenced']").click();

		driver.findElementByXPath(
				"//span[text()='Processing Mode']//parent::span//following-sibling::div[@class='uiMenu']").click();

		driver.findElementByXPath("//a[@title='External']").click();

		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();

		Thread.sleep(2000);

	}
}