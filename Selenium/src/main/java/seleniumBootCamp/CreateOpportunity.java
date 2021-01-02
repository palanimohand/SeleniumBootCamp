package seleniumBootCamp;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateOpportunity {

	public static void main(String[] args) throws InterruptedException {

		//Create prefs map to store all preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//Put this into prefs map to switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create chrome options to set this prefs
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

		WebElement oppDropDown = driver.findElementByXPath("//a[@title='Opportunities']");

		Thread.sleep(3000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", oppDropDown);

		Thread.sleep(5000);

		driver.findElementByXPath("//a[@title='New']").click();

		Thread.sleep(3000);
		
		String oppname = "Salesforce Automation by Palanimohan";

		driver.findElementByXPath("//span[text()='Opportunity Name']//parent::label//following-sibling::input")
				.sendKeys(oppname);

		driver.findElementByXPath("//span[text()='Close Date']//parent::label//following-sibling::div/input").click();

		driver.findElementByXPath("//button[text()='Today']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Stage' and (not(contains(@title,'Stage')))]//parent::span//following::div[1]").click();

		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[@title='Needs Analysis']").click();
		
		driver.findElementByXPath("//div[@class='inlineFooter']/div/div//child::button/span[text()='Save']").click();
		
		Thread.sleep(10000);
		
		String scannedtext = driver.findElementByXPath("//div[@class='slds-media__body']/h1/div//following::slot/slot/lightning-formatted-text").getText();
		
		if(scannedtext.trim().equals(oppname.trim())) {
			System.out.println("Name Match");
		}else {
			System.out.println("Name mismatch");
		}
		
		driver.quit();;
		
	}

}
