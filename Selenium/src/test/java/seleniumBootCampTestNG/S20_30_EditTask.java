package seleniumBootCampTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S20_30_EditTask extends BeforeExecution {

	@Test(groups = { "a" }, dataProvider = "provideData")
	public void editTask(String browser, String username, String password, String url) throws InterruptedException {

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

		waitToBeClickable(By.xpath("//a[@title='Tasks']"));

		WebElement taskdd = driver.findElementByXPath("//a[@title='Tasks']");

		Actions action = new Actions(driver);

		action.click(taskdd).build().perform();

		waitToBeClickable(By.xpath("//a[contains(@class,'downIcon')]"));

		driver.findElementByXPath("//a[contains(@class,'downIcon')]").click();

		waitToBeClickable(By.xpath("//li[contains(@class,'slds-dropdown')]//span[text()='Recently Viewed']"));

		driver.findElementByXPath("//li[contains(@class,'slds-dropdown')]//span[text()='Recently Viewed']").click();

		waitToBeClickable(By.xpath("//a[@title='Show 13 more actions']"));

		driver.findElementByXPath("//a[@title='Show 13 more actions']").click();

		waitToBeClickable(By.xpath("//div[@title='Edit']"));

		WebElement editdd = driver.findElementByXPath("//div[@title='Edit']");

		action.click(editdd).build().perform();

		waitToBeClickable(By.xpath("//span[text()='Due Date']//parent::label//following-sibling::div/input"));

		driver.findElementByXPath("//span[text()='Due Date']//parent::label//following-sibling::div/input").click();

		driver.findElementByXPath("//button[text()='Today']").click();

		driver.findElementByXPath("//span[text()='Priority']//parent::span//following::div[@class='uiMenu'][2]")
				.click();

		waitToBeClickable(By.xpath("//a[@title='Low']"));

		driver.findElementByXPath("//a[@title='Low']").click();

		waitToBeClickable(By.xpath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']"));

		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();

		waitToBeClickable(By.xpath("//span[text()='Subject']//parent::div//following-sibling::div/span"));

		String text = driver.findElementByXPath("//span[text()='Subject']//parent::div//following-sibling::div/span")
				.getText();

		if (text.equals("Boot Camp")) {
			System.out.println(text + ": Subject Match");
		} else {
			System.out.println(text + ": Subject Mismatch");
		}

	}

}
