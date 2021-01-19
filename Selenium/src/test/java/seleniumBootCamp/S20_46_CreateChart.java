package seleniumBootCamp;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S20_46_CreateChart {

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

		driver.findElementByXPath("//p[text()='Service Console']").click();

		Thread.sleep(10000);

		driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();

		Thread.sleep(1000);

		driver.findElementByXPath("//span[text()='Refunds' and starts-with(@class,'menuLabel')]").click();

		Thread.sleep(5000);
		
		driver.findElementByXPath("//span[text()='Recently Viewed']//parent::div//following-sibling::a").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//span[text()='All']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//button[@title='Show charts']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[@title='Settings']/lightning-icon").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[@title='New Chart']").click();

		Thread.sleep(3000);
		
		driver.findElementByXPath("//span[text()='Chart Name']//parent::label//following-sibling::input").sendKeys("Practice Chart");
		
		driver.findElementByXPath("//span[text()='Chart Type']//parent::span//following-sibling::div/div/div/div/a").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("/html/body/div[9]/div/ul/li[1]/a").click();
		
		driver.findElementByXPath("//span[text()='Aggregate Type']//parent::span//following-sibling::div/div/div/div/a").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("/html/body/div[10]/div/ul/li[1]/a").click();
		
		driver.findElementByXPath("//span[text()='Aggregate Field']//parent::span//following-sibling::div/div/div/div/a").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("/html/body/div[11]/div/ul/li[2]/a").click();
		
		driver.findElementByXPath("//span[text()='Grouping Field']//parent::span//following-sibling::div/div/div/div/a").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("/html/body/div[12]/div/ul/li[1]/a").click();
		
		driver.findElementByXPath("//button[@title='Save']").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//a[@title='Settings']/lightning-icon").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//a[@title='Horizontal Bar Chart']").click();
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
