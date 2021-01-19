package seleniumBootCampTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S20_31_DeleteTask extends BeforeExecution {

	@Test(groups = { "a" }, dataProvider = "provideData")
	public void deletetask(String browser, String username, String password, String url) throws InterruptedException {

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

		waitToBeClickable(By.xpath("//div[@title='Delete']"));

		WebElement deletedd = driver.findElementByXPath("//div[@title='Delete']");

		action.click(deletedd).build().perform();

		driver.findElementByXPath("//span[text()='Delete']").click();

		waitToBeClickable(By.xpath("//div[starts-with(@class,'toastContent')]/div/span"));

		String text = driver.findElementByXPath("//div[starts-with(@class,'toastContent')]/div/span").getText();

		if (text.contains("Task") && text.contains("was deleted")) {
			System.out.println("Match");
		} else {
			System.out.println("MisMatch");
		}

	}

}
