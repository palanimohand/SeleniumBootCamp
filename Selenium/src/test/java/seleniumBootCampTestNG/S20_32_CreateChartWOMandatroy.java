package seleniumBootCampTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class S20_32_CreateChartWOMandatroy extends BeforeExecution {

	@Test(groups = { "chart" }, dataProvider = "provideData")
	public void createChartWOMandatory(String browser, String username, String password, String url) throws InterruptedException {

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

		waitToBeClickable(By.xpath("//a[@title='Tasks']//following::a"));

		WebElement taskdd = driver.findElementByXPath("//a[@title='Tasks']//following::a");

		Actions action = new Actions(driver);

		action.click(taskdd).build().perform();

		waitToBeClickable(By.xpath("//span[text()='New Task']//ancestor::a"));

		WebElement newtask = driver.findElementByXPath("//span[text()='New Task']//ancestor::a");

		action.click(newtask).build().perform();

		waitToBeClickable(By.xpath("//span[text()='Name']//parent::label//following::input[1]"));

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").click();

		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys("Sarath M");

		waitToBeClickable(By.xpath("//div[@title='Sarath M']"));

		driver.findElementByXPath("//div[@title='Sarath M']").click();

		driver.findElementByTagName("textarea").sendKeys("SALES FORCE Automation Using Selenium");

		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();

		waitToBeClickable(By.xpath("//ul[@class='errorsList']/li"));

		String text = driver.findElementByXPath("//ul[@class='errorsList']/li").getText();

		if (text.trim().equalsIgnoreCase("These required fields must be completed: Subject")) {
			System.out.println("Match");
		} else {
			System.out.println("No Match");
		}

	}

}
