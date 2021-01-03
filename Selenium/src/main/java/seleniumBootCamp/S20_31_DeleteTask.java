package seleniumBootCamp;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class S20_31_DeleteTask {

	public static void main(String[] args) throws InterruptedException {

		// Create prefs map to store all preferences
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Put this into prefs map to switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver",
				"/Users/palanimohan/Documents/Career/qualityEngineer/Softwares/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
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
		
		if(text.contains("Task") && text.contains("was deleted")) {
			System.out.println("Match");
		}else {
			System.out.println("MisMatch");
		}
		
		driver.quit();
	}

}
