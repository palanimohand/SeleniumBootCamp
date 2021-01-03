package seleniumBootCamp;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S20_29_CreateTask {

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

		driver.findElementByXPath("//a[starts-with(@class,'globalCreateTrigger')]").click();

		Thread.sleep(4000);

		driver.findElementByXPath("//a[@title='New Task']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//span[text()='Name']//parent::label//following::input[1]").sendKeys("Sarath M");
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//div[@title='Sarath M']").click();
		
		driver.findElementByXPath("//span[text()='Status']//parent::span//following::a[1]").click();
		
		driver.findElementByXPath("//a[@title='Waiting on someone else']").click();

		driver.findElementByXPath("//label[text()='Subject']//parent::label//following::input[1]").sendKeys("Boot Camp");
		
		driver.findElementByXPath("//button[contains(@class,'publisherShareButton')]").click();		
		
		Thread.sleep(3000);
		
		String txt = driver.findElementByXPath("//span[contains(@class,'forceActionsText')]").getText();
		
		System.out.println(txt);
		
		if(txt.contains("Task") && txt.contains("was created")) {
			System.out.println("Match");
		}else {
			System.out.println("MisMatch");
		}
		
		driver.quit();
	}

}
